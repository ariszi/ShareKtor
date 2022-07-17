package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class TransactedItemDto(
    val id: String,
    val category: ItemCategoryDto,
    val subCategory: ItemSubCategoryDto? = null,
    val itemDescription: String? = null,
    val tags: List<TagDto>? = null


) {


}
