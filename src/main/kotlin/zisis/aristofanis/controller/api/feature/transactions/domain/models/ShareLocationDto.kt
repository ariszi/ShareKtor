package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class ShareLocationDto(
    val latlng: LatLng?,
    val area: String?,
    val city: String?,
    val country: String?,
    val zipCode: String?,
    val address: String?,
    val addressNumber: String?
)

@Serializable
data class LatLng(val lat: Double, val lng: Double)