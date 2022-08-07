package zisis.aristofanis.controller.api.feature.transactions.presentation.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.domain.models.ContactInfoDto
import zisis.aristofanis.controller.api.feature.transactions.domain.models.LatLngDto
import zisis.aristofanis.controller.api.feature.transactions.domain.models.ShareLocationDto
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionItemDto

@Serializable
@Resource(path = "/transaction")
data class CreateTransactionResource(
    val user_id: String,
    val recipient_id: String? = null,
    val requestors_comment: String? = null,
    val transaction_item_id: String? = null,
    val transaction_item_description: String? = null,
    val requestor_info_id: String? = null,
    val requestor_info_name: String? = null,
    val requestor_info_phone: String? = null,
    val requestor_info_email: String? = null,
    val recipient_info_id: String? = null,
    val recipient_info_name: String? = null,
    val recipient_info_phone: String? = null,
    val recipient_info_email: String? = null,
    val transaction_location: String? = null,
    val transaction_lat: Double? = null,
    val transaction_lng: Double? = null,
    val transaction_area: String? = null,
    val transaction_city: String? = null,
    val transaction_country: String? = null,
    val transaction_zip_code: String? = null,
    val transaction_address: String? = null,
    val transaction_address_number: String? = null
) {
    fun toDto(): TransactionDto {
        val transactionItemDto = TransactionItemDto(
            id = transaction_item_id,
            itemDescription = transaction_item_description,
        )
        val requestorInfo = ContactInfoDto(
            userId = requestor_info_id,
            fullName = requestor_info_name,
            phoneNumber = requestor_info_phone,
            email = requestor_info_email
        )
        val recipientInfo = ContactInfoDto(
            userId = recipient_info_id,
            fullName = recipient_info_name,
            phoneNumber = recipient_info_phone,
            email = recipient_info_email
        )

        val transactionLocation = ShareLocationDto(
            latlng = LatLngDto(lat = transaction_lat, lng = transaction_lng),
            area = transaction_area,
            city = transaction_city,
            country = transaction_country,
            zipCode = transaction_zip_code,
            address = transaction_address,
            addressNumber = transaction_address_number
        )

        return TransactionDto(
            creatorsId = user_id,
            recipientId = recipient_id,
            requestorsComment = requestors_comment,
            item = transactionItemDto,
            requestorInfo = requestorInfo,
            recipientInfo = recipientInfo,
            transactionLocation = transactionLocation
        )
    }
}