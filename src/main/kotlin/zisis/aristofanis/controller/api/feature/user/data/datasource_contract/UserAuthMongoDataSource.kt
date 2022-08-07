package zisis.aristofanis.controller.api.feature.user.data.datasource_contract

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.feature.user.domain.models.CredentialsDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto

interface UserAuthMongoDataSource {

    suspend fun createUser(userDto: UserDto): Result<UserDto>

    suspend fun retrieveUser(credentialsDto: CredentialsDto): Result<UserDto>

}