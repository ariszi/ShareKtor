package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.Tag

@Serializable
data class TagDto(
    val id: String = "",
    val name: String,
    val tagCategory: TagCategoryDto,
    val color: Int? = null
) {
    fun toDomain(): Tag {
        return Tag(
            name = name,
            tag_category = tagCategory.toDomain(),
            color = color
        )
    }
}