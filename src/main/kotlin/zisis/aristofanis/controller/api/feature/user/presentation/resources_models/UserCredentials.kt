package zisis.aristofanis.controller.api.feature.user.presentation.resources_models

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("user/authorise")
data class UserCredentials(val email: String, val password: String)