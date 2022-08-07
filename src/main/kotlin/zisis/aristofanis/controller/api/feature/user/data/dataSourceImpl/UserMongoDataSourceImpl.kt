package zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl

import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.CoroutineCollection
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserMongoDataSource
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto


class UserMongoDataSourceImpl(private val userCollection: CoroutineCollection<User>) : UserMongoDataSource {
    private val userExceptions = UserExceptions()

    override suspend fun getUserById(id: String): Result<UserDto> {
        val user = userCollection.find().toList().find { it.id.toString() == id }
        return user?.let { Result.Success(it.toDto()) } ?: UserExceptions.NoUserFoundException.toError()
    }

    override suspend fun getAllUsers(): Result<UsersDto> {
        val usersList = userCollection.find().toList()
        return if (usersList.isNotEmpty()) {
            Result.Success(UsersDto(usersList.map { it.toDto() }))
        } else {
            UserExceptions.NoUsersFoundException.toError()
        }
    }

    override suspend fun deleteUserById(userId: String): Result<String> {
        return if (userCollection.deleteOneById(ObjectId(userId)).wasAcknowledged()) {
            Result.Success("User deleted successfully")
        } else {
            UserExceptions.NoUserFoundException.toError()
        }
    }

}