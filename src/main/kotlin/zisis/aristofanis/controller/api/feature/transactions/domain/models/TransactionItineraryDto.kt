package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.TransactionItinerary

@Serializable
data class TransactionItineraryDto(
    val status: String,
    val requestorStatus: String,
    val recipientStatus: String,
    val contributorStatus: String
) {
    fun toMongoSchemaModel(): TransactionItinerary? {
        return TransactionItinerary(
            status = toTransactionStatus(status),
            requestor_status = toParticipantStatus(requestorStatus),
            recipient_status = toParticipantStatus(recipientStatus),
            contributor_status = toParticipantStatus(contributorStatus)
        )

    }

    private fun toParticipantStatus(participantStatus: String): TransactionItinerary.ParticipantsStatus {
        return when (participantStatus) {
            "interested" -> TransactionItinerary.ParticipantsStatus.INTERESTED
            "agreed" -> TransactionItinerary.ParticipantsStatus.AGREED
            "declined" -> TransactionItinerary.ParticipantsStatus.DECLINED
            else -> TransactionItinerary.ParticipantsStatus.DEFAULT
        }
    }

    private fun toTransactionStatus(transactionStatus: String): TransactionItinerary.TransactionStatus {
        return when (transactionStatus) {
            "requested" -> TransactionItinerary.TransactionStatus.REQUESTED
            "acquired" -> TransactionItinerary.TransactionStatus.ACQUIRED
            "completed" -> TransactionItinerary.TransactionStatus.COMPLETED
            "in_progress" -> TransactionItinerary.TransactionStatus.IN_PROGRESS
            "cancelled" -> TransactionItinerary.TransactionStatus.CANCELED
            "expired" -> TransactionItinerary.TransactionStatus.EXPIRED
            else -> TransactionItinerary.TransactionStatus.DEFAULT
        }
    }
}