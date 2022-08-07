package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionReportDto

@Serializable
data class TransactionReport(
    val requestorReport: String?,
    val contributorReport: String?,
    val recipientReport: String?
) {
    fun toDto(): TransactionReportDto {
        return TransactionReportDto(
            requestorReport = requestorReport,
            contributorReport = contributorReport,
            recipientReport = recipientReport
        )
    }
}