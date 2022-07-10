package zisis.aristofanis.controller.api.feature.user.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CredentialsDto(val email: String, val password: String)
