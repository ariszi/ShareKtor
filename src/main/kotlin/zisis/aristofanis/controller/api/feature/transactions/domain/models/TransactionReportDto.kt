package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class TransactionReportDto(
    val requestorReport: String?,
    val contributorReport: String?,
    val recipientReport: String?
)