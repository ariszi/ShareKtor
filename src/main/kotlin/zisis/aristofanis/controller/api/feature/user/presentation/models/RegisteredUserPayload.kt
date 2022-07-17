package zisis.aristofanis.controller.api.feature.user.presentation.models

import zisis.aristofanis.controller.api.core.domain.token.Token
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto

data class RegisteredUserPayload(val token: Token, val user: UserDto)