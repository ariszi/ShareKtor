package zisis.aristofanis.controller.api.feature.user.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.user.data.models.User

@Serializable
data class UserDto(
    val id: String? = null,
    val email: String,
    val password: String,
    val phoneNumber: String? = null,
    val phonePrefix: String? = null,
    val gender: String? = null,
    val name: String,
    val age: Int? = null,
    val country: String? = null
) {
    fun toDomain(): User =
        User(
            name = this.name,
            age = this.age,
            phonePrefix = this.phonePrefix,
            phoneNumber = this.phoneNumber,
            gender = this.gender,
            email = this.email,
            password = this.password,
            country = this.country
        )
}