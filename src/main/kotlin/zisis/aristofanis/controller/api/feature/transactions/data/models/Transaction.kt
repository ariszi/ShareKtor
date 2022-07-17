package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Transaction(
    @BsonId val id: Id<Transaction>? = null,
    val creators_id: String,
    val recipient_id: String? = null,
    val item: TransactedItem,
    val requestorsComment: String? = null,
    val requestorInfo: ContactInfo? = null,
    val recipientInfo: ContactInfo? = null,
    val contributorInfo: ContactInfo? = null,
    val handshake: TransactionItinerary? = null,
    val transactionLocation: ShareLocation? = null,
    val report: TransactionReport? = null
) {
//    fun toDto(): TransactionDto =
//        TransactionDto(
//            id = this.id.toString(),
//        )
}