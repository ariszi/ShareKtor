package zisis.aristofanis.controller.api.feature.user.domain.repoImpl

import com.auth0.jwk.JwkProvider
import com.auth0.jwk.JwkProviderBuilder
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.config.*
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.State
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserAuthMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserAuthRepositoryContract
import zisis.aristofanis.controller.api.feature.user.presentation.responses.AuthenticationResponse
import zisis.aristofanis.controller.api.feature.user.presentation.responses.RegistrationResponse
import java.util.*
import java.util.concurrent.TimeUnit

class UsersAuthRepositoryImpl(envConfig: ApplicationConfig, private val dataSource: UserAuthMongoDbDataSource) :
    UserAuthRepositoryContract {

    val secret = envConfig.property("jwt.secret").getString()
    private val issuer = envConfig.property("jwt.issuer").getString()
    private val audience = envConfig.property("jwt.audience").getString()
    private val myRealm = envConfig.property("jwt.realm").getString()

    private val jwkProvider: JwkProvider = JwkProviderBuilder(issuer)
        .cached(10, 24, TimeUnit.HOURS)
        .rateLimited(10, 1, TimeUnit.MINUTES)
        .build()

    override suspend fun authenticateUser(email: String, password: String): AuthenticationResponse {

        return when (val result = dataSource.retrieveUser(email, password)) {
            is Result.Success -> {
                if (result.value.password == password)
                    AuthenticationResponse(status = State.SUCCESS, token = tokenGeneration(email))
                else UserExceptions.WrongPasswordException.toError()
            }
            is Result.Error -> {
                AuthenticationResponse(status = State.FAILED, error = result)
            }
        }
    }


    override suspend fun registerUser(params: Parameters): RegistrationResponse {
        val email = params["email"] ?: "test"
        val password = params["password"] ?: "test"
        val name = params["name"] ?: "test"
        val userDto = UserDto(email = email, password = password, name = name)
        return when (val result = userInputValidation(params)) {
            is Result.Success -> validateDataSourceResponse(dataSource.createUser(userDto))
            is Result.Error -> RegistrationResponse(status = State.FAILED, error = result)
        }
    }

    private fun userInputValidation(params: Parameters): Result<Unit> {
        val email = params["email"]
        val password = params["password"]
        val name = params["name"]
        val age = params["age"]?.toIntOrNull()
        age?.let { if (it > 110) return UserExceptions.AgeTooHighException.toError() }
        if (name.isNullOrEmpty()) return UserExceptions.NameEmptyException.toError()
        if (password.isNullOrEmpty()) return UserExceptions.NameEmptyException.toError()
        if (email.isNullOrEmpty()) return UserExceptions.NameEmptyException.toError()
        if (name.length > 1019) return UserExceptions.NameToBigException.toError()
        return Result.Success(Unit)
    }

    private fun validateDataSourceResponse(result: Result<UserDto>): RegistrationResponse {
        return when (result) {
            is Result.Success -> {
                RegistrationResponse(status = State.SUCCESS, token = tokenGeneration(result.value.email))
            }
            is Result.Error -> {
                RegistrationResponse(status = State.FAILED, error = result)
            }
        }
    }

    private fun tokenGeneration(email: String): String = JWT.create()
        .withAudience(audience)
        .withIssuer(issuer)
        .withClaim("email", email)
        .withExpiresAt(Date(System.currentTimeMillis() + 60000))
        .sign(Algorithm.HMAC256(secret))
}