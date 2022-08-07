package zisis.aristofanis.controller.api.feature.user.presentation

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import zisis.aristofanis.controller.api.VERSION_1
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserRepositoryContract
import zisis.aristofanis.controller.api.feature.user.presentation.resources.FindUserResource
import zisis.aristofanis.controller.api.feature.user.presentation.resources.GetUsersResource


fun Route.userRouting(userRepository: UserRepositoryContract) {

    authenticate {
        route(VERSION_1) {

            get<GetUsersResource> {
                call.respond(userRepository.getUsers())
            }

            get<FindUserResource> { request ->
                call.respond(userRepository.getUser(request.userId))
            }

            delete<FindUserResource> { request ->
                call.respond(userRepository.deleteUser(request.userId))
            }
        }
    }
}