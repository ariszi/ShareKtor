package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.util.idValue
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto

@Serializable
data class Transaction(
    @BsonId val id: Id<Transaction>? = null,
    val creators_id: String,
    val recipient_id: String? = null,
    val item: TransactedItem,
    val requestors_comment: String? = null,
    val requestor_info: ContactInfo? = null,
    val recipient_info: ContactInfo? = null,
    val contributor_info: ContactInfo? = null,
    val handshake: TransactionItinerary? = null,
    val transaction_location: ShareLocation? = null,
    val report: TransactionReport? = null
) {
    fun toDto(): TransactionDto {
        return TransactionDto(
            id = id.idValue.toString(),
            creatorsId = creators_id,
            recipientId = recipient_id,
            item = item.toDto(),
            requestorsComment = requestors_comment,
            requestorInfo = requestor_info?.toDto(),
            recipientInfo = recipient_info?.toDto(),
            contributorInfo = contributor_info?.toDto(),
            handshake = handshake?.toDto(),
            transactionLocation = transaction_location?.toDto(),
            report = report?.toDto()
        )

    }
}
