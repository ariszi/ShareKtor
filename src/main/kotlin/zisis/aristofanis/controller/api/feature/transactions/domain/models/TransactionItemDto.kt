package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.TransactedItem

@Serializable
data class TransactionItemDto(
    val id: String?,
    val category: ItemCategoryDto? = null,
    val subCategory: ItemSubCategoryDto? = null,
    val itemDescription: String? = null,
    val tags: List<String>? = null
) {
    fun toMongoSchemaModel(): TransactedItem {
        return TransactedItem(
            category = category?.toMongoSchemaModel(),
            sub_category = subCategory?.toMongoSchemaModel(),
            item_description = itemDescription,
            tags = tags
        )

    }
}