package zisis.aristofanis.controller.api.feature.user.presentation.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource(path = "/users")
class GetUsersResource