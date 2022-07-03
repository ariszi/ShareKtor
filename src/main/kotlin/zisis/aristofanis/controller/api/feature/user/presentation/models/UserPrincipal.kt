package zisis.aristofanis.controller.api.feature.user.presentation.models

import io.ktor.server.auth.*
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto

data class UserPrincipal(val userDto: UserDto):Principal