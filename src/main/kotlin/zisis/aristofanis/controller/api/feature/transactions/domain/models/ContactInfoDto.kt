package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.ContactInfo

@Serializable
data class ContactInfoDto(val fullName: String?, val phoneNumber: String?, val email: String?) {
    fun toDomain(): ContactInfo? {
        TODO("Not yet implemented")
    }
}