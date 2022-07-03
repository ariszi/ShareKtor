package zisis.aristofanis.controller.api.feature.user.presentation

import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import zisis.aristofanis.controller.api.VERSION_1
import zisis.aristofanis.controller.api.feature.user.domain.repoContracts.UserRepositoryContract
import zisis.aristofanis.controller.api.feature.user.presentation.resources_models.FindUser
import zisis.aristofanis.controller.api.feature.user.presentation.resources_models.GetUsers
import zisis.aristofanis.controller.api.feature.user.presentation.resources_models.CreateUserResource


fun Route.userRouting(userRepository: UserRepositoryContract) {

    route(VERSION_1) {

        get<GetUsers> {
            call.respond(userRepository.getUsers())
        }

        get<FindUser> { request ->
            call.respond(userRepository.getUser(request.userId))
        }

        delete<FindUser> { request ->
            call.respond(userRepository.deleteUser(request.userId))
        }
    }
}