package zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl

import com.mongodb.BasicDBObject
import org.litote.kmongo.coroutine.CoroutineCollection
import zisis.aristofanis.controller.api.core.data.toResult
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.mapError
import zisis.aristofanis.controller.api.core.domain.onSuccess
import zisis.aristofanis.controller.api.core.domain.validateMap
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserAuthMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto


class UserAuthMongoDbDataSourceImpl(private val userCollection: CoroutineCollection<User>) : UserAuthMongoDbDataSource {


    override suspend fun createUser(userDto: UserDto): Result<UserDto> {
        val searchQry = BasicDBObject();
        searchQry["email"] = userDto.email
        userCollection.find(searchQry).toResult().onSuccess {
            return UserExceptions.EmailIsAlreadyUsedException.toError()
        }
        return if (userCollection.insertOne(userDto.toDomain()).wasAcknowledged()) {
            Result.Success(userDto)
        } else {
            UserExceptions.UserCreationException.toError()
        }
    }

    override suspend fun retrieveUser(email: String, password: String): Result<UserDto> {
        val searchQry = BasicDBObject();
        searchQry["email"] = email
        return userCollection.find(searchQry).toResult().validateMap { it.toDto() }
            .mapError { UserExceptions.NoUserFoundException.toError() }
    }

}