package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.ShareLocation

@Serializable
data class ShareLocationDto(
    val latlng: LatLngDto?,
    val area: String?,
    val city: String?,
    val country: String?,
    val zipCode: String?,
    val address: String?,
    val addressNumber: String?
) {
    fun toDomain(): ShareLocation? {
        TODO("Not yet implemented")
    }
}

@Serializable
data class LatLngDto(val lat: Double, val lng: Double)