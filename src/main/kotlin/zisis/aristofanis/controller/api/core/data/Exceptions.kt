package zisis.aristofanis.controller.api.core.data

import zisis.aristofanis.controller.api.core.domain.SimpleError
import zisis.aristofanis.controller.api.core.domain.Response
import zisis.aristofanis.controller.api.core.domain.Result

data class MalformedContractError(val cause: Throwable) : Result.Error()

object GenericException : Throwable(), MappableError {
    override fun toError(): Result.Error =
        SimpleError(message = "Something went wrong. Try again later", type = "GENERIC_ERROR")
}

interface MappableError {
    fun toError(): Result.Error
}

interface MappableResponse {
    fun toError(): Response
}
