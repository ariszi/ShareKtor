package zisis.aristofanis.controller.api.feature.user.presentation.resources_models

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource(path = "/user")
data class FindUser(val userId: String)