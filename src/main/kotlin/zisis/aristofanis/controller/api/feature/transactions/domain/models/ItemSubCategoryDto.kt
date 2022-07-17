package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable


@Serializable
data class ItemSubCategoryDto(
    val id: String,
    val subCategoryName: String,
    val parentCategory: ItemCategoryDto,
    val subCategoryDescription: String,
)