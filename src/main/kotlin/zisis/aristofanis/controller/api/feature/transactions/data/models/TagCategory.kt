package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TagCategory(val name: String, val color: Int? = null)