package zisis.aristofanis.controller.api.feature.user.presentation.resources_models

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource(path = "/users")
class GetUsers