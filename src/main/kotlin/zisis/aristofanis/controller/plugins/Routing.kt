package zisis.aristofanis.controller.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.litote.kmongo.coroutine.CoroutineDatabase
import zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl.UserAuthMongoDbDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl.UserMongoDbDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.api.feature.user.domain.repoImpl.UsersAuthRepositoryImpl
import zisis.aristofanis.controller.api.feature.user.domain.repoImpl.UsersRepositoryImpl
import zisis.aristofanis.controller.api.feature.user.presentation.authRouting
import zisis.aristofanis.controller.api.feature.user.presentation.userRouting

fun Application.configureRouting(database: CoroutineDatabase) {
    val userCollection = database.getCollection<User>()
    val mongoDbUserDataSource = UserMongoDbDataSourceImpl(userCollection)
    val mongoDbUserAuthDataSource = UserAuthMongoDbDataSourceImpl(userCollection)
    val envConfig = environment.config

    routing {
        userRouting(UsersRepositoryImpl(mongoDbUserDataSource))
        authRouting(UsersAuthRepositoryImpl(envConfig, mongoDbUserAuthDataSource))
    }
}