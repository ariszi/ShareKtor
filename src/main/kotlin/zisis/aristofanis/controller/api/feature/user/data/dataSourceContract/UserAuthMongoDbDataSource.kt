package zisis.aristofanis.controller.api.feature.user.data.dataSourceContract

import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto
import zisis.aristofanis.controller.api.core.domain.Result

interface UserAuthMongoDbDataSource {

    suspend fun createUser(user: UserDto): Result<UserDto>

    suspend fun retrieveUser(email: String, password: String): Result<UserDto>

}