package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.TagCategory

@Serializable
data class TagCategoryDto(val name: String, val color: Int? = null) {
    fun toMongoSchemaModel(): TagCategory {
        return TagCategory(name, color)
    }
}