package zisis.aristofanis.controller.api.core.presentation.responses

import zisis.aristofanis.controller.api.core.domain.Result

data class SimpleResponse(
    override val status: State = State.SUCCESS,
    override val message: String = "Success",
    override val error: Result.Error? = null,
    override val payload: Any? = null
) : Response