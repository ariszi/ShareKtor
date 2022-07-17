package zisis.aristofanis.controller.api.feature.user.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UsersDto(val users: List<UserDto>)  {
    fun toDomain(): Users =
        Users(
            users = this.users.map { it.toDomain() }
        )
}