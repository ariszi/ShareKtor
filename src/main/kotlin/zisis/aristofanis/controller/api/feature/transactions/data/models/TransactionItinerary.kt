package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TransactionItinerary(
    val status: TransactionStatus = TransactionStatus.INVALID,
    val requestorStatus: ParticipantsStatus,
    val recipientStatus: ParticipantsStatus,
    val contributorStatus: ParticipantsStatus
) {
    enum class ParticipantsStatus {
        INTERESTED,
        AGREED,
        DECLINED
    }

    enum class TransactionStatus {
        REQUESTED,
        ACQUIRED,
        COMPLETED,
        IN_PROGRESS,
        CANCELED,
        EXPIRED,
        INVALID
    }
}