package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class TransactionItineraryDto(
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