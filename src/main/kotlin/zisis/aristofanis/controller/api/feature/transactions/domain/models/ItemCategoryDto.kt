package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.ItemCategory


@Serializable
data class ItemCategoryDto(
    val id: String = "",
    val categoryName: String,
    val categoryDescription: String,
) {
    fun toDomain(): ItemCategory {
        return ItemCategory(
            category_name = categoryName,
            categoryDescription = categoryDescription
        )
    }
}