package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable


@Serializable
data class ItemCategoryDto(
    val id: String,
    val categoryName:String,
    val categoryDescription:String,
)