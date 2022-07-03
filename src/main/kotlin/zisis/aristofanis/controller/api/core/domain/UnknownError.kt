package zisis.aristofanis.controller.api.core.domain

data class UnknownError(val cause: Throwable?) : Result.Error()
