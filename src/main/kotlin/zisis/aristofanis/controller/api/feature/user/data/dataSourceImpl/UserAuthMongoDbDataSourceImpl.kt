package zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl

import com.mongodb.BasicDBObject
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.json
import org.slf4j.LoggerFactory
import zisis.aristofanis.controller.api.core.data.toResult
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.mapError
import zisis.aristofanis.controller.api.core.domain.onSuccess
import zisis.aristofanis.controller.api.core.domain.validateMap
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserAuthMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions
import zisis.aristofanis.controller.api.feature.user.domain.models.CredentialsDto
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto


class UserAuthMongoDbDataSourceImpl(private val userCollection: CoroutineCollection<User>) : UserAuthMongoDbDataSource {

    val logger = LoggerFactory.getLogger(UserAuthMongoDbDataSourceImpl::class.java)
    override suspend fun createUser(userDto: UserDto): Result<UserDto> {
        val searchQry = BasicDBObject();
        searchQry["email"] = userDto.email
        userCollection.find(searchQry).toResult().onSuccess {
            return UserExceptions.EmailIsAlreadyUsedException.toError()
        }
        userCollection.insertOne(userDto.toDomain()).run {
            return if (this.wasAcknowledged()) {
                this.json
                logger.debug(("Hello from module!" +  this.json) )
                Result.Success(
                    userDto.copy(
                        id = this.insertedId?.toString() ?: "Frick. This didn't work"
                    )
                )
            } else {
                UserExceptions.UserCreationException.toError()
            }
        }
    }

    override suspend fun retrieveUser(credentialsDto: CredentialsDto): Result<UserDto> {
        val searchQry = BasicDBObject()
        searchQry["email"] = credentialsDto.email
        return userCollection.find(searchQry).toResult().validateMap { it.toDto() }
            .mapError { UserExceptions.NoUserFoundException.toError() }
    }

}

