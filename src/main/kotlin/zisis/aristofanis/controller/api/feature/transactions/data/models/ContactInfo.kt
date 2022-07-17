package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ContactInfo(val fullName: String?, val phoneNumber: String?, val email: String?)