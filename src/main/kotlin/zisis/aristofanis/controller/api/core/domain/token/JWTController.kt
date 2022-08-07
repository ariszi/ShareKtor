package zisis.aristofanis.controller.api.core.domain.token

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.config.*
import java.util.*

class JWTController(envConfig: ApplicationConfig) {

    private val secret = envConfig.property("jwt.secret").getString()
    private val issuer = envConfig.property("jwt.issuer").getString()
    private val audience = envConfig.property("jwt.audience").getString()
    private val myRealm = envConfig.property("jwt.realm").getString()

    //method to generate token
    fun generateToken(data: String): Token {
        val minutes = 10
        val expirationDate = Date(System.currentTimeMillis() + 60_000L * minutes)
        val tokenString =  JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("id", data)
            .withExpiresAt(expirationDate)
            .sign(Algorithm.HMAC256(secret))
        return Token(token = tokenString,expirationDate = expirationDate)
    }

    // method to verify token receive
    fun verifyToken(): JWTVerifier {
        return JWT.require(Algorithm.HMAC256(secret))
            .withAudience(audience)
            .withIssuer(issuer)
            .build()
    }

}