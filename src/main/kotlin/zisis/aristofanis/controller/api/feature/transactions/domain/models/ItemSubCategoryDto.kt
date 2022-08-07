package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.ItemSubCategory


@Serializable
data class ItemSubCategoryDto(
    val id: String = "",
    val subCategoryName: String,
    val parentCategory: ItemCategoryDto,
    val subCategoryDescription: String,
) {
    fun toMongoSchemaModel(): ItemSubCategory {
        return ItemSubCategory(
            sub_category_name = subCategoryName,
            parent_category = parentCategory.toMongoSchemaModel(),
            sub_category_description = subCategoryDescription
        )
    }
}