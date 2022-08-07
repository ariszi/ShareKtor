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
import zisis.aristofanis.controller.api.feature.user.data.datasource_impl.UserMongoDataSourceImpl
import zisis.aristofanis.controller.api.feature.user.data.models.User
import zisis.aristofanis.controller.plugins.plugin_configs.auth_config.authenticationConfig
import zisis.aristofanis.controller.plugins.plugin_configs.configStatusPages


fun Application.configPlugIns(database: CoroutineDatabase) {
    val userCollection = database.getCollection<User>()
    val userMongoDbDataSource = UserMongoDataSourceImpl(userCollection)
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