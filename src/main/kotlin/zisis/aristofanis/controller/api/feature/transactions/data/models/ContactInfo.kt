package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.domain.models.ContactInfoDto

@Serializable
data class ContactInfo(val full_name: String?, val phone_number: String?, val email: String?) {
    fun toDto(): ContactInfoDto {
        return ContactInfoDto(
            fullName = full_name,
            phoneNumber = phone_number,
            email = email
        )
    }
}