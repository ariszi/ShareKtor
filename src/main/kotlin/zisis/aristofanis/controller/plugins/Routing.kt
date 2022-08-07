package zisis.aristofanis.controller.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.litote.kmongo.coroutine.CoroutineDatabase
import zisis.aristofanis.controller.api.core.domain.token.JWTController
import zisis.aristofanis.controller.api.feature.user.data.datasource_impl.UserAuthMongoDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.datasource_impl.UserMongoDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.api.feature.user.domain.repoImpl.UsersAuthRepositoryImpl
import zisis.aristofanis.controller.api.feature.user.domain.repoImpl.UsersRepositoryImpl
import zisis.aristofanis.controller.api.feature.user.presentation.authRouting
import zisis.aristofanis.controller.api.feature.user.presentation.userRouting

fun Application.configureRouting(database: CoroutineDatabase) {
    val userCollection = database.getCollection<User>()
    val mongoDbUserDataSource = UserMongoDataSourceImpl(userCollection)
    val mongoDbUserAuthDataSource = UserAuthMongoDataSourceImpl(userCollection)
    val envConfig = environment.config
    val jwtController = JWTController(envConfig)

    routing {
        userRouting(UsersRepositoryImpl(mongoDbUserDataSource))
        authRouting(UsersAuthRepositoryImpl(jwtController, mongoDbUserAuthDataSource, mongoDbUserDataSource))
    }
}