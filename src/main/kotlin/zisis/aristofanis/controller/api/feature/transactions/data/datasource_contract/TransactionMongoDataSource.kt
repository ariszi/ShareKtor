package zisis.aristofanis.controller.api.feature.transactions.data.datasource_contract

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto

interface TransactionMongoDataSource {

   suspend fun createTransaction(transactionDto: TransactionDto): Result<TransactionDto>

    suspend fun updateTransactionStatus(): Result<TransactionDto>

    suspend  fun claimTransactionAsContributor(): Result<TransactionDto>

    suspend  fun cancelTransaction(): Result<TransactionDto>

    suspend  fun reportTransaction(): Result<TransactionDto>

    suspend fun addContactInfoToTransaction(): Result<TransactionDto>

    suspend  fun createTransactionShareArea(): Result<TransactionDto>

    suspend fun updateItem(): Result<TransactionDto>

    suspend  fun addCommentToTransaction(): Result<TransactionDto>

    suspend  fun updateHandshake(): Result<TransactionDto>


}