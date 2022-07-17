package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class TagCategoryDto(val name: String, val color: Int? = null)