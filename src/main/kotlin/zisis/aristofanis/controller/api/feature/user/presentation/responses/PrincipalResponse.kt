package zisis.aristofanis.controller.api.feature.user.presentation.responses

import zisis.aristofanis.controller.api.core.domain.Response
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.State
import zisis.aristofanis.controller.api.feature.user.presentation.models.UserPrincipal

data class PrincipalResponse(
    override val status: State,
    override val message: String = "Authorization response",
    override val error: Result.Error? = null,
    val userPrincipal: UserPrincipal? = null
) : Response