package zisis.aristofanis.controller.api.feature.user.presentation.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto

@Serializable
@Resource("/user/register")
data class CreateUserResource(
    val email: String,
    val password: String,
    val phoneNumber: String? = null,
    val phonePrefix: String? = null,
    val gender: String? = null,
    val name: String,
    val age: String? = null,
    val country: String? = null
) {
    fun toDto(): UserDto =
        UserDto(
            name = this.name,
            age = this.age?.toInt(),
            phonePrefix = this.phonePrefix,
            phoneNumber = this.phoneNumber,
            gender = this.gender,
            email = this.email,
            password = this.password,
            country = this.country
        )
}