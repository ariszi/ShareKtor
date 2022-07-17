package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id


@Serializable
data class ItemCategory(
    @BsonId val id: Id<ItemCategory>? = null,
    val categoryName:String,
    val categoryDescription:String,
)