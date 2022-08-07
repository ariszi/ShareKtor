package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionItemDto

@Serializable
data class TransactedItem(
    @BsonId val id: Id<TransactedItem>? = null,
    val category: ItemCategory?,
    val sub_category: ItemSubCategory? = null,
    val item_description: String? = null,
    val tags: List<String>? = null


) {
    fun toDto(): TransactionItemDto {
        return TransactionItemDto(
            id = id?.toString(),
            category = category?.toDto(),
            subCategory = sub_category?.toDto(),
            itemDescription = item_description,
            tags = tags
        )
    }


}
