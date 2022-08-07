package zisis.aristofanis.controller.api.feature.transactions.domain.models

import kotlinx.serialization.Serializable
import zisis.aristofanis.controller.api.feature.transactions.data.models.TransactionReport

@Serializable
data class TransactionReportDto(
    val requestorReport: String?,
    val contributorReport: String?,
    val recipientReport: String?
) {
    fun toDomain(): TransactionReport? {
        TODO("Not yet implemented")
    }
}