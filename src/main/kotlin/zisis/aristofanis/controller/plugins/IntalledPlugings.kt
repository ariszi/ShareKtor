package zisis.aristofanis.controller.plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.resources.*
import zisis.aristofanis.controller.plugins.pluginconfigs.authConfig.authenticationConfig
import zisis.aristofanis.controller.plugins.pluginconfigs.configStatusPages


fun Application.configPlugIns() {

    val envConfig = environment.config

    install(DefaultHeaders)

    install(Resources)
    install(ContentNegotiation) {
        gson()
    }
    install(StatusPages) {
        configStatusPages()
    }
    install(Authentication) {
        authenticationConfig(envConfig)
    }

}