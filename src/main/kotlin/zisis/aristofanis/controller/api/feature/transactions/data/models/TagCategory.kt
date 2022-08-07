package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TagCategoryDto

@Serializable
data class TagCategory(val name: String, val color: Int? = null) {
    fun toDto(): TagCategoryDto {
        return TagCategoryDto(name = name, color = color)
    }
}