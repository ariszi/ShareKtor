package zisis.aristofanis.controller.api.core.domain

import kotlinx.serialization.Serializable

@Serializable
data class SimpleError(
    val message: String,
    val type: String? = null
) :  Result.Error()