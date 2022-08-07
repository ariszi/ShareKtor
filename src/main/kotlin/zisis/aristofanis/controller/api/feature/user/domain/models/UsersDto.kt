package zisis.aristofanis.controller.api.feature.user.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.user.data.models.Users

@Serializable
data class UsersDto(val users: List<UserDto>)  {
    fun toMongoSchemaModel(): Users =
        Users(
            users = this.users.map { it.toMongoSchemaModel() }
        )
}