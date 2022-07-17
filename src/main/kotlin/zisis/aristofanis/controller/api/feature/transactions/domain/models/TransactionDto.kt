package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class TransactionDto(
    val id: String,
    val creators_id: String,
    val recipient_id: String? = null,
    val item: TransactedItemDto,
    val requestorsComment: String? = null,
    val requestorInfo: ContactInfoDto? = null,
    val recipientInfo: ContactInfoDto? = null,
    val contributorInfo: ContactInfoDto? = null,
    val handshake: TransactionItineraryDto? = null,
    val transactionLocation: ShareLocationDto? = null,
    val report: TransactionReportDto? = null
) {
//    fun toDto(): TransactionDto =
//        TransactionDto(
//            id = this.id.toString(),
//        )
}