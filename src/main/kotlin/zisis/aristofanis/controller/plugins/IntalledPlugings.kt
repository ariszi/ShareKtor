package zisis.aristofanis.controller.plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.resources.*
import org.litote.kmongo.coroutine.CoroutineDatabase
import zisis.aristofanis.controller.api.core.domain.token.JWTController
import zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl.UserAuthMongoDbDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.dataSourceImpl.UserMongoDbDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.plugins.pluginconfigs.authConfig.authenticationConfig
import zisis.aristofanis.controller.plugins.pluginconfigs.configStatusPages


fun Application.configPlugIns(database: CoroutineDatabase) {
    val userCollection = database.getCollection<User>()
    val userAuthMongoDbDataSource = UserAuthMongoDbDataSourceImpl(userCollection)
    val userMongoDbDataSource = UserMongoDbDataSourceImpl(userCollection)
    val envConfig = environment.config
    val jwtController = JWTController(envConfig)

    install(DefaultHeaders)

    install(Resources)
    install(ContentNegotiation) {
        gson()
    }
    install(StatusPages) {
        configStatusPages()
    }
    install(Authentication) {
        authenticationConfig(
            jwtController,
            userMongoDbDataSource
        )
    }

}