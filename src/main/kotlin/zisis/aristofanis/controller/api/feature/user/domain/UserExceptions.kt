package zisis.aristofanis.controller.api.feature.user.domain

import zisis.aristofanis.controller.api.core.data.MappableError
import zisis.aristofanis.controller.api.core.data.MappableResponse
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.SimpleError
import zisis.aristofanis.controller.api.core.presentation.responses.State
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.ERROR_CREATING_USER
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.ERROR_NAME_IS_EMPTY
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.ERROR_NAME_IS_TOO_BIG
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.ERROR_RETURNING_USER
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.ERROR_RETURNING_USERS
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.ERROR_USER_AGE_TOO_HIGH
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.USER_WITH_THAT_EMAIL_ALREADY_EXISTS
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions.ErrorType.WRONG_PASSWORD
import zisis.aristofanis.controller.api.feature.user.presentation.responses.AuthenticationResponse

class UserExceptions {
    private object ErrorType {
        const val ERROR_CREATING_USER = "ERROR_CREATING_USER"
        const val ERROR_RETURNING_USERS = "ERROR_RETURNING_USERS"
        const val ERROR_RETURNING_USER = "ERROR_RETURNING_USER"
        const val WRONG_PASSWORD = "WRONG_PASSWORD"
        const val ERROR_USER_AGE_TOO_HIGH = "ERROR_USER_AGE_TOO_HIGH"
        const val ERROR_NAME_IS_EMPTY = "ERROR_NAME_IS_EMPTY"
        const val ERROR_NAME_IS_TOO_BIG = "ERROR_NAME_IS_TOO_BIG"
        const val USER_WITH_THAT_EMAIL_ALREADY_EXISTS = "USER_WITH_THAT_EMAIL_ALREADY_EXISTS"

    }

    object UserCreationException : Exception(), MappableError {
        override fun toError(): Result.Error =
            SimpleError(type = ERROR_CREATING_USER, message = "Error creating user")
    }

    object NoUsersFoundException : Exception(), MappableError {
        override fun toError(): Result.Error =
            SimpleError(type = ERROR_RETURNING_USERS, message = "No Users were found")
    }

    object NoUserFoundException : Exception(), MappableError {
        override fun toError(): Result.Error =
            SimpleError(type = ERROR_RETURNING_USER, message = "The user was not found")

    }   object EmailIsAlreadyUsedException : Exception(), MappableError {
        override fun toError(): Result.Error =
            SimpleError(type = USER_WITH_THAT_EMAIL_ALREADY_EXISTS, message = "This email is already registered")
    }

    object WrongPasswordException : Exception(), MappableResponse {
        override fun toError(): AuthenticationResponse =
            AuthenticationResponse(
                status = State.FAILED,
                message = "Your password doesn't match your email",
                error = SimpleError(type = WRONG_PASSWORD, message = "Your password doesn't match your email")
            )
    }

    object AgeTooHighException : Exception(), MappableError {
        override fun toError() =
            SimpleError(type = ERROR_USER_AGE_TOO_HIGH, message = "Please be serious and add your real age")
    }

    object NameEmptyException : Exception(), MappableError {
        override fun toError() =
            SimpleError(type = ERROR_NAME_IS_EMPTY, message = "Name is required for registration")
    }

    object NameToBigException : Exception(), MappableError {
        override fun toError() =
            SimpleError(type = ERROR_NAME_IS_TOO_BIG, message = "Please be add a name that has reasonable length")
    }


}


