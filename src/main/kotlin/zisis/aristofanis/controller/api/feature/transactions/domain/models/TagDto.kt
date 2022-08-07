package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.Tag

@Serializable
data class TagDto(
    val id: String? = null,
    val name: String? = null,
    val tagCategory: TagCategoryDto,
    val color: Int? = null
) {
    fun toMongoSchemaModel(): Tag {
        return Tag(
            name = name,
            tag_category = tagCategory.toMongoSchemaModel(),
            color = color
        )
    }
}