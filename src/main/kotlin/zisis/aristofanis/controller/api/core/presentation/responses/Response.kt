package zisis.aristofanis.controller.api.core.presentation.responses

import zisis.aristofanis.controller.api.core.domain.Result

/**
 * Response model to expose in API response
 */
interface Response {
    val status: State
    val message: String
    val error: Result.Error?
    val payload: Any?
}

/**
 * HTTP Response Status. Used for evaluation of [HttpResponse] type.
 */
enum class State {
    SUCCESS, NOT_FOUND, FAILED, UNAUTHORIZED
}