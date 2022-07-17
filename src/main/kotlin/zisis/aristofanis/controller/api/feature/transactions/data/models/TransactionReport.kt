package zisis.aristofanis.controller.api.feature.transactions.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TransactionReport(val requestorReport: String?, val contributorReport: String?, val recipientReport: String?)