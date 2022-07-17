package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Tag(@BsonId val id: Id<Tag>? = null, val name: String, val tagCategory: TagCategory, val color: Int? = null)