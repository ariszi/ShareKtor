package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.util.idValue
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TagDto

@Serializable
data class Tag(
    @BsonId val id: Id<Tag>? = null,
    val name: String,
    val tag_category: TagCategory,
    val color: Int? = null
) {
    fun toDto(): TagDto {
        return TagDto(id = id.idValue.toString(), name = name, tagCategory = tag_category.toDto(), color = color)
    }
}