package zisis.aristofanis.controller.api.feature.user.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import zisis.aristofanis.controller.api.feature.user.domain.models.UserDto

@Serializable
data class User(
    @BsonId val id: Id<User>? = null,
    val email: String,
    val password: String,
    val phoneNumber: String?,
    val phonePrefix: String?,
    val gender: String?,
    val name: String,
    val age: Int?,
    val country: String?
) {
    fun toDto(): UserDto =
        UserDto(
            id = this.id.toString(),
            name = this.name,
            password = this.password,
            age = this.age,
            country = this.country,
            email = this.email,
            gender = this.gender,
            phoneNumber = this.phoneNumber,
            phonePrefix = this.phonePrefix
        )
}