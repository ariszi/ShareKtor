package zisis.aristofanis.controller.api.feature.user.domain.repoImpl

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.State
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserRepositoryContract
import zisis.aristofanis.controller.api.feature.user.presentation.responses.UserResponse

class UsersRepositoryImpl(private val dataSource: UserMongoDbDataSource) : UserRepositoryContract {

    override suspend fun getUser(id: String): UserResponse {
        return when (val result = dataSource.getUserById(id)) {
            is Result.Success -> UserResponse(payload = UsersDto(listOf(result.value)))
            is Result.Error -> UserResponse(status = State.FAILED, error = result)
        }
    }

    override suspend fun getUsers(): UserResponse {
        return when (val result = dataSource.getAllUsers()) {
            is Result.Success -> UserResponse(payload = (result.value))
            is Result.Error -> UserResponse(status = State.FAILED, error = result)
        }
    }

    override suspend fun deleteUser(userId: String): UserResponse {
        return when (val result = dataSource.deleteUserById(userId)) {
            is Result.Success -> UserResponse(message = result.value)
            is Result.Error -> UserResponse(status = State.FAILED, error = result)
        }
    }

    override suspend fun updateUser(userId: String): UserResponse {
        TODO("Not yet implemented")
    }

}