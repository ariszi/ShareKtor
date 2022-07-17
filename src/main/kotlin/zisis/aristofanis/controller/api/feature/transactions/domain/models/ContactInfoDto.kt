package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ContactInfoDto(val fullName: String?, val phoneNumber: String?, val email: String?)