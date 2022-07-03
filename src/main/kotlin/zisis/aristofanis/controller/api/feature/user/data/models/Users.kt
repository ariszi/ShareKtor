package zisis.aristofanis.controller.api.feature.user.data.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.user.domain.models.UsersDto

@Serializable
data class Users(val users: List<User>) {
    fun toDto(): UsersDto =
        UsersDto(
            users = this.users.map { it.toDto() }
        )
}