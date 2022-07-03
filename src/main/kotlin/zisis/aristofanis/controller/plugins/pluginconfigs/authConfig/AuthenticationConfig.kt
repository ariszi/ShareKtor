package zisis.aristofanis.controller.plugins.pluginconfigs.authConfig

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.config.*
import io.ktor.server.response.*

fun AuthenticationConfig.authenticationConfig(envConfig: ApplicationConfig) {

    val secret = envConfig.property("jwt.secret").getString()
    val issuer = envConfig.property("jwt.issuer").getString()
    val audience = envConfig.property("jwt.audience").getString()
    val myRealm = envConfig.property("jwt.realm").getString()

    jwt("jwt-auth") {
        realm = myRealm
        verifier(
            JWT
            .require(Algorithm.HMAC256(secret))
            .withAudience(audience)
            .withIssuer(issuer)
            .build())

//        validate { credential ->
//            val userId = credential.payload.getClaim("id").asString()
//        }
        challenge { defaultScheme, realm ->
            call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
        }
    }
}