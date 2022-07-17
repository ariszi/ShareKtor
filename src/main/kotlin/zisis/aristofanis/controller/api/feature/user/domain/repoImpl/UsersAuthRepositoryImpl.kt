package zisis.aristofanis.controller.api.feature.user.domain.repoImpl

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.State
import zisis.aristofanis.controller.api.core.domain.token.JWTController
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.TransactionMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions
import zisis.aristofanis.controller.api.feature.user.domain.models.CredentialsDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserAuthRepositoryContract
import zisis.aristofanis.controller.api.feature.user.presentation.models.RegisteredUserPayload
import zisis.aristofanis.controller.api.feature.user.presentation.models.UserPrincipal
import zisis.aristofanis.controller.api.feature.user.presentation.responses.AuthenticationResponse
import zisis.aristofanis.controller.api.feature.user.presentation.responses.PrincipalResponse
import zisis.aristofanis.controller.api.feature.user.presentation.responses.RegistrationResponse

class UsersAuthRepositoryImpl(
    private val tokenController: JWTController,
    private val userAuthDataSource: TransactionMongoDbDataSource,
    private val userDataSource: UserMongoDbDataSource
) :
    UserAuthRepositoryContract {

    override suspend fun authenticateUser(credentialsDto: CredentialsDto): AuthenticationResponse {

        return when (val result = userAuthDataSource.retrieveUser(credentialsDto)) {
            is Result.Success -> {

                if (result.value.password == credentialsDto.password)
                    AuthenticationResponse(
                        status = State.SUCCESS,
                        payload = tokenController.generateToken(result.value.id)
                    )
                else UserExceptions.WrongPasswordException.toError()
            }
            is Result.Error -> {
                AuthenticationResponse(status = State.FAILED, error = result)
            }
        }
    }


    override suspend fun registerUser(userDto: UserDto): RegistrationResponse {
        return when (val result = userInputValidation(userDto)) {
            is Result.Success -> validateDataSourceResponse(userAuthDataSource.createUser(userDto))
            is Result.Error -> RegistrationResponse(status = State.FAILED, error = result)
        }
    }

    override suspend fun getUser(id: String): PrincipalResponse {
        return when (val result = userDataSource.getUserById(id)) {
            is Result.Success -> PrincipalResponse(status = State.SUCCESS, payload = UserPrincipal(result.value))
            is Result.Error -> PrincipalResponse(status = State.FAILED, error = result)
        }
    }

    private fun userInputValidation(user: UserDto): Result<Unit> {
        user.age?.let { if (it > 110) return UserExceptions.AgeTooHighException.toError() }
        if (user.name.isEmpty()) return UserExceptions.NameEmptyException.toError()
        if (user.name.length > 1019) return UserExceptions.NameToBigException.toError()
        return Result.Success(Unit)
    }

    private fun validateDataSourceResponse(result: Result<UserDto>): RegistrationResponse {
        return when (result) {
            is Result.Success -> {
                RegistrationResponse(
                    status = State.SUCCESS,
                    payload = RegisteredUserPayload(tokenController.generateToken(result.value.id), result.value)
                )
            }
            is Result.Error -> {
                RegistrationResponse(status = State.FAILED, error = result)
            }
        }
    }
}