package zisis.aristofanis.controller.api.feature.user.presentation.responses

import zisis.aristofanis.controller.api.core.domain.Response
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.State
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto

data class UserResponse(
    override val status: State = State.SUCCESS,
    override val message: String = "Authorization response",
    override val error: Result.Error? = null,
    val usersDto: UsersDto? = null
) : Response