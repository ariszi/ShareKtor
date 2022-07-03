package zisis.aristofanis.controller.api.core.domain

import zisis.aristofanis.controller.api.core.data.MalformedContractError
import zisis.aristofanis.controller.api.core.data.MappableError

inline fun <R> runSuspendCatching(block: () -> R): Result<R> {
    return runCatching {
        Result.Success(block())
    }.getOrElse { e: Throwable ->
        e.toError()
    }
}

fun <T> successOf(value: T) = Result.Success(value)

fun Throwable.toError(): Result.Error {
    return if (this is MappableError) {
        this.toError()
    } else {
        UnknownError(this)
    }
}

inline fun <T, R> Result<T>.validateMap(mapper: (T) -> R): Result<R> = try {
    map(mapper)
} catch (exception: NullPointerException) {
    MalformedContractError(exception)
}

inline fun <T, R> Result<T>.map(mapper: (T) -> R): Result<R> = when (this) {
    is Result.Success -> Result.Success(mapper(value))
    is Result.Error -> this
}

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> = when (this) {
    is Result.Success -> apply { action(value) }
    is Result.Error -> this
}

inline fun <T> Result<T>.mapError(mapper: (Result.Error) -> Result.Error): Result<T> = when (this) {
    is Result.Success -> this
    is Result.Error -> mapper(this)
}

inline fun <T> Result<T>.onError(action: (Result.Error) -> Unit): Result<T> = when (this) {
    is Result.Success -> this
    is Result.Error -> apply { action(this) }
}

inline fun <T, R>Result<T>.then(mapper: (T) -> Result<R>): Result<R> = when (this) {
    is Result.Success -> mapper(value)
    is Result.Error -> this
}


fun <T> Result<T>.successOrNull(): T? = when (this) {
    is Result.Success -> value
    else -> null
}
