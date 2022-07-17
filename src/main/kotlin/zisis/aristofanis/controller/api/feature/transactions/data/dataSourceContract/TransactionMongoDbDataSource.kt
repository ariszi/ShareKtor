package zisis.aristofanis.controller.api.feature.transactions.data.dataSourceContract

import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto

interface TransactionMongoDbDataSource {

    fun createTransaction(): Result<TransactionDto>

    fun updateTransactionStatus(): Result<TransactionDto>

    fun claimTransactionAsContributor(): Result<TransactionDto>

    fun cancelTransaction(): Result<TransactionDto>

    fun reportTransaction(): Result<TransactionDto>

    fun addContactInfoToTransaction(): Result<TransactionDto>

    fun createTransactionShareArea(): Result<TransactionDto>

    fun updateItem(): Result<TransactionDto>

    fun addCommentToTransaction(): Result<TransactionDto>

    fun updateHandshake(): Result<TransactionDto>


}