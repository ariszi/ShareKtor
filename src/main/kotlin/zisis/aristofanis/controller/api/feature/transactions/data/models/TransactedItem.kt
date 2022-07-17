package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class TransactedItem(
    @BsonId val id: Id<TransactedItem>? = null,
    val category: ItemCategory,
    val subCategory: ItemSubCategory? = null,
    val itemDescription: String? = null,
    val tags: List<Tag>? = null


) {


}
