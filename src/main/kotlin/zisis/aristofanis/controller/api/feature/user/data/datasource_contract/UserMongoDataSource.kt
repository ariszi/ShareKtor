package zisis.aristofanis.controller.api.feature.user.data.datasource_contract

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto

interface UserMongoDataSource {

    suspend fun getUserById(id: String): Result<UserDto>

    suspend fun getAllUsers(): Result<UsersDto>

    suspend fun deleteUserById(userId: String): Result<String>


}