package zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl

import com.mongodb.BasicDBObject
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.util.idValue
import zisis.aristofanis.controller.api.core.data.toResult
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.mapError
import zisis.aristofanis.controller.api.core.domain.onSuccess
import zisis.aristofanis.controller.api.core.domain.validateMap
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.TransactionMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions
import zisis.aristofanis.controller.api.feature.user.domain.models.CredentialsDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto


class UserAuthMongoDbDataSourceImpl(private val userCollection: CoroutineCollection<User>) : TransactionMongoDbDataSource {


    override suspend fun createUser(userDto: UserDto): Result<UserDto> {
        val searchQry = BasicDBObject();
        searchQry["email"] = userDto.email
        userCollection.find(searchQry).toResult().onSuccess {
            return UserExceptions.EmailIsAlreadyUsedException.toError()
        }
        val userInsertResult = userCollection.insertOne(userDto.toDomain())
        return if (userInsertResult.wasAcknowledged()) {
            Result.Success(userDto.copy(id = userInsertResult.idValue.toString()))
        } else {
            UserExceptions.UserCreationException.toError()
        }
    }

    override suspend fun retrieveUser(credentialsDto: CredentialsDto): Result<UserDto> {
        val searchQry = BasicDBObject()
        searchQry["email"] = credentialsDto.email
        return userCollection.find(searchQry).toResult().validateMap { it.toDto() }
            .mapError { UserExceptions.NoUserFoundException.toError() }
    }

}