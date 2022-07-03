package zisis.aristofanis.controller.plugins.pluginconfigs

import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import zisis.aristofanis.controller.api.core.domain.SimpleError
import zisis.aristofanis.controller.api.core.domain.State
import zisis.aristofanis.controller.api.core.presentation.models.FailureResponse

fun StatusPagesConfig.configStatusPages() {
    exception<Throwable> { call, throwable ->
        call.respond(
            HttpStatusCode.BadRequest,
            FailureResponse(error = SimpleError(message = throwable.message ?: "Bad Request"))
        )
    }

    status(HttpStatusCode.InternalServerError) { call, status ->
        call.respond(status, FailureResponse(error = SimpleError(message = "Pass required message")))
    }

    status(HttpStatusCode.Unauthorized) { call, status ->
        call.respond(status, FailureResponse(error = SimpleError(message = "Pass required message")))
    }
}