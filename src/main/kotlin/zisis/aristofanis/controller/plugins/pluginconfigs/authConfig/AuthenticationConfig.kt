package zisis.aristofanis.controller.plugins.pluginconfigs.authConfig

import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.token.JWTController
import zisis.aristofanis.controller.api.feature.user.data.dataSourceContract.UserMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.presentation.models.UserPrincipal

fun AuthenticationConfig.authenticationConfig(jwtController: JWTController, dataSource: UserMongoDbDataSource) {


    jwt() {

        verifier(jwtController.verifyToken())

        validate { credential ->

            val id = credential.payload.getClaim("id").asString()

            when (val user = dataSource.getUserById(id)) {
                is Result.Success -> UserPrincipal(user.value)
                is Result.Error -> null

            }
        }
        challenge { defaultScheme, realm ->
            call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
        }
    }
}