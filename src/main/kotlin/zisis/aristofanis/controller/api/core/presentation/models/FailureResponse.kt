package zisis.aristofanis.controller.api.core.presentation.models

import zisis.aristofanis.controller.api.core.domain.Response
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.State

data class FailureResponse(
    override val status: State = State.FAILED,
    override val message: String = "Something went wrong",
    override val error: Result.Error? = null,
    val token: String? = null
) : Response