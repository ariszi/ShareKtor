package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionItineraryDto

@Serializable
data class TransactionItinerary(
    val status: TransactionStatus = TransactionStatus.INVALID,
    val requestor_status: ParticipantsStatus,
    val recipient_status: ParticipantsStatus,
    val contributor_status: ParticipantsStatus
) {
    fun toDto(): TransactionItineraryDto? {
        return TransactionItineraryDto(
            status = status.toString(),
            requestorStatus = requestor_status.toString(),
            recipientStatus = recipient_status.toString(),
            contributorStatus = contributor_status.toString()
        )
    }

    enum class ParticipantsStatus {
        INTERESTED,
        AGREED,
        DECLINED,
        DEFAULT
    }

    enum class TransactionStatus {
        REQUESTED,
        ACQUIRED,
        COMPLETED,
        IN_PROGRESS,
        CANCELED,
        EXPIRED,
        INVALID,
        DEFAULT
    }
}