package zisis.aristofanis.controller.api.feature.user.presentation

import io.ktor.server.application.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import zisis.aristofanis.controller.api.VERSION_1
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserAuthRepositoryContract
import zisis.aristofanis.controller.api.feature.user.presentation.resources.CreateUserResource
import zisis.aristofanis.controller.api.feature.user.presentation.resources.UserCredentials


fun Route.authRouting(repository: UserAuthRepositoryContract) {

    route(VERSION_1) {
        post<UserCredentials> { request ->
            call.respond(repository.authenticateUser(request.toDto()))
        }

        post<CreateUserResource> { request ->
            call.respond(repository.registerUser(request.copy().toDto()))
        }
    }
}