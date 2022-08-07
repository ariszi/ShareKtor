package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.ContactInfo

@Serializable
data class ContactInfoDto(
    val userId: String? = null,
    val fullName: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null
) {
    fun toMongoSchemaModel(): ContactInfo? {
        return ContactInfo(
            user_id = userId,
            full_name = fullName,
            phone_number = phoneNumber,
            email = email
        )
    }
}