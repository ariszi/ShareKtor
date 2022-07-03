package zisis.aristofanis.controller.api.core.domain

sealed class Result<out T> {

    abstract class Error : Result<Nothing>()

    data class Success<T>(val value: T) : Result<T>()

    override fun toString(): String = when (this) {
        is Success -> "Success[$value]"
        is Error -> "Error[${super.toString()}]"
    }

}

