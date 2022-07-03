package zisis.aristofanis.controller.api.feature.user.domain.repoImpl

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserRepositoryContract

class UsersRepositoryImpl(private val dataSource: UserMongoDbDataSource) : UserRepositoryContract {

    override suspend fun getUser(id: String): Result<UserDto> {
        return dataSource.getUserById(id)
    }

    override suspend fun getUsers(): Result<UsersDto> {
        return dataSource.getAllUsers()
    }

    override suspend fun updateUser(userId: String): Result<UserDto> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(userId: String): Result<String> {
        return dataSource.deleteUserById(userId)
    }

}