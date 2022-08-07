package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.util.idValue
import zisis.aristofanis.controller.api.feature.transactions.domain.models.ItemSubCategoryDto


@Serializable
data class ItemSubCategory(
    @BsonId val id: Id<ItemSubCategory>? = null,
    val sub_category_name: String,
    val parent_category: ItemCategory,
    val sub_category_description: String,
) {
    fun toDto(): ItemSubCategoryDto {
        return ItemSubCategoryDto(
            id = id?.idValue.toString(),
            subCategoryName = sub_category_name,
            parentCategory = parent_category.toDto(),
            subCategoryDescription = sub_category_description
        )
    }
}