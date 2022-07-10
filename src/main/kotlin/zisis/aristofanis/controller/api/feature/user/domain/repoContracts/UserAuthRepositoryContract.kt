package zisis.aristofanis.controller.api.feature.user.domain.repoContracts

import zisis.aristofanis.controller.api.feature.user.domain.models.CredentialsDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.presentation.responses.AuthenticationResponse
import zisis.aristofanis.controller.api.feature.user.presentation.responses.PrincipalResponse
import zisis.aristofanis.controller.api.feature.user.presentation.responses.RegistrationResponse

interface UserAuthRepositoryContract {

    suspend fun authenticateUser(credentialsDto: CredentialsDto): AuthenticationResponse

    suspend fun registerUser(userDto: UserDto): RegistrationResponse

    suspend fun getUser(id: String): PrincipalResponse

}