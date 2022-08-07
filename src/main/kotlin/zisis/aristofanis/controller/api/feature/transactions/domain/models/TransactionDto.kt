package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.Transaction

@Serializable
data class TransactionDto(
    val id: String = "",
    val creatorsId: String,
    val recipientId: String? = null,
    val item: TransactionItemDto,
    val requestorsComment: String? = null,
    val requestorInfo: ContactInfoDto? = null,
    val recipientInfo: ContactInfoDto? = null,
    val contributorInfo: ContactInfoDto? = null,
    val handshake: TransactionItineraryDto? = null,
    val transactionLocation: ShareLocationDto? = null,
    val report: TransactionReportDto? = null
) {
    fun toMongoSchemaModel(): Transaction {
        return Transaction(
            creators_id = creatorsId,
            recipient_id = recipientId,
            item = item.toMongoSchemaModel(),
            requestors_comment = requestorsComment,
            requestor_info = requestorInfo?.toMongoSchemaModel(),
            recipient_info = recipientInfo?.toMongoSchemaModel(),
            contributor_info = contributorInfo?.toMongoSchemaModel(),
            handshake = handshake?.toMongoSchemaModel(),
            transaction_location = transactionLocation?.toMongoSchemaModel(),
            report = report?.toMongoSchemaModel()
        )
    }
}
