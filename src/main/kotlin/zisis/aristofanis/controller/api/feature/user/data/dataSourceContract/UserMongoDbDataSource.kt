package zisis.aristofanis.controller.api.feature.user.data.dataSourceContract

import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto
import zisis.aristofanis.controller.api.core.domain.Result

interface UserMongoDbDataSource {

    suspend fun getUserById(id: String): Result<UserDto>

    suspend fun getAllUsers(): Result<UsersDto>

    suspend fun deleteUserById(userId: String): Result<String>


}