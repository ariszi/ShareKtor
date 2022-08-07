package zisis.aristofanis.controller.api.feature.user.presentation.responses

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.presentation.responses.Response
import zisis.aristofanis.controller.api.core.presentation.responses.State
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto

data class UserResponse(
    override val status: State = State.SUCCESS,
    override val message: String = "Authorization response",
    override val error: Result.Error? = null,
    override val payload: UsersDto? = null
) : Response