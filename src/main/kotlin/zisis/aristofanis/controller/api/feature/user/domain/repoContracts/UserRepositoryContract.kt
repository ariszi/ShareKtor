package zisis.aristofanis.controller.api.feature.user.domain.repoContracts

import zisis.aristofanis.controller.api.feature.user.presentation.responses.UserResponse

interface UserRepositoryContract {

    suspend fun getUser(id: String): UserResponse

    suspend fun getUsers(): UserResponse

    suspend fun updateUser(userId: String): UserResponse

    suspend fun deleteUser(userId: String): UserResponse

}