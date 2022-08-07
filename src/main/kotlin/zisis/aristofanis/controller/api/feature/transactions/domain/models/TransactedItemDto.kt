package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.TransactedItem

@Serializable
data class TransactedItemDto(
    val id: String?,
    val category: ItemCategoryDto?,
    val subCategory: ItemSubCategoryDto? = null,
    val itemDescription: String? = null,
    val tags: List<TagDto>? = null
) {
    fun toDomain(): TransactedItem {
        return TransactedItem(
            category = category?.toDomain(),
            sub_category = subCategory?.toDomain(),
            item_description = itemDescription,
            tags = tags?.map { it.toDomain() } ?: emptyList()
        )

    }
}