package zisis.aristofanis.controller.api.feature.user.domain.repoContracts

import io.ktor.http.*
import zisis.aristofanis.controller.api.feature.user.presentation.responses.AuthenticationResponse
import zisis.aristofanis.controller.api.feature.user.presentation.responses.RegistrationResponse

interface UserAuthRepositoryContract {

    suspend fun authenticateUser(email:String, password:String): AuthenticationResponse

    suspend fun registerUser(userDto: Parameters): RegistrationResponse

}