package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.ShareLocation

@Serializable
data class ShareLocationDto(
    val latlng: LatLngDto? = null,
    val area: String?,
    val city: String?,
    val country: String?,
    val zipCode: String?,
    val address: String?,
    val addressNumber: String?
) {
    fun toMongoSchemaModel(): ShareLocation? {
        TODO("Not yet implemented")
    }
}

@Serializable
data class LatLngDto(val lat: Double? = null, val lng: Double? = null)