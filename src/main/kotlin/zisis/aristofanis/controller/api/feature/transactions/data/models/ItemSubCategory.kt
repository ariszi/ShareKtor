package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id


@Serializable
data class ItemSubCategory(
    @BsonId val id: Id<ItemSubCategory>? = null,
    val subCategoryName: String,
    val parentCategory: ItemCategory,
    val subCategoryDescription: String,
)