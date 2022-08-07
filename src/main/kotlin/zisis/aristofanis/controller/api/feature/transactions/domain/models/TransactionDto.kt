package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.Transaction

@Serializable
data class TransactionDto(
    val id: String = "",
    val creatorsId: String,
    val recipientId: String? = null,
    val item: TransactedItemDto,
    val requestorsComment: String? = null,
    val requestorInfo: ContactInfoDto? = null,
    val recipientInfo: ContactInfoDto? = null,
    val contributorInfo: ContactInfoDto? = null,
    val handshake: TransactionItineraryDto? = null,
    val transactionLocation: ShareLocationDto? = null,
    val report: TransactionReportDto? = null
) {
    fun toDomain(): Transaction {
        return Transaction(
            creators_id = creatorsId,
            recipient_id = recipientId,
            item = item.toDomain(),
            requestors_comment = requestorsComment,
            requestor_info = requestorInfo?.toDomain(),
            recipient_info = recipientInfo?.toDomain(),
            contributor_info = contributorInfo?.toDomain(),
            handshake = handshake?.toDomain(),
            transaction_location = transactionLocation?.toDomain(),
            report = report?.toDomain()
        )
    }
}


//{
//    fun toDto(): TransactedItemDto {
//        return TransactedItemDto(
//            id = id,
//            category = category,
//            subCategory = subCategory,
//            itemDescription = itemDescription,
//            tags = tags
//        )
//
//    }
//}
