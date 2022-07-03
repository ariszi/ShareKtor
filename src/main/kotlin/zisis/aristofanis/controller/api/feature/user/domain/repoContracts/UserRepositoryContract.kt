package zisis.aristofanis.controller.api.feature.user.domain.repoContracts

import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto
import zisis.aristofanis.controller.api.core.domain.Result

interface UserRepositoryContract {

    suspend fun getUser(id: String): Result<UserDto>

    suspend fun getUsers(): Result<UsersDto>

    suspend fun updateUser(userId: String): Result<UserDto>

    suspend fun deleteUser(userId: String): Result<String>

}