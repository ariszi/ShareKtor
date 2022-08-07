package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.domain.models.LatLngDto
import zisis.aristofanis.controller.api.feature.transactions.domain.models.ShareLocationDto

@Serializable
data class ShareLocation(
    val latlng: LatLng?,
    val area: String?,
    val city: String?,
    val country: String?,
    val zip_code: String?,
    val address: String?,
    val address_number: String?
) {
    fun toDto(): ShareLocationDto? {
        return ShareLocationDto(
            latlng = latlng?.toDto(),
            area = area,
            city = city,
            country = country,
            zipCode = zip_code,
            address = address,
            addressNumber = address_number
        )
    }
}

@Serializable
data class LatLng(val lat: Double, val lng: Double) {
    fun toDto(): LatLngDto {
        return LatLngDto(lat, lng)
    }
}