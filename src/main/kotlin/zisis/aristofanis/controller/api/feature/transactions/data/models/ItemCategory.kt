package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.util.idValue
import zisis.aristofanis.controller.api.feature.transactions.domain.models.ItemCategoryDto


@Serializable
data class ItemCategory(
    @BsonId val id: Id<ItemCategory>? = null,
    val category_name: String,
    val categoryDescription: String,
) {
    fun toDto(): ItemCategoryDto {
        return ItemCategoryDto(
            id = id.idValue.toString(),
            categoryName = category_name,
            categoryDescription = categoryDescription
        )
    }
}