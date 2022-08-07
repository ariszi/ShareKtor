package zisis.aristofanis.controller.api.feature.user.presentation.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.user.domain.models.CredentialsDto

@Serializable
@Resource("user/authorise")
data class UserCredentials(val email: String, val password: String) {
    fun toDto(): CredentialsDto = CredentialsDto(email = email, password = password)
}