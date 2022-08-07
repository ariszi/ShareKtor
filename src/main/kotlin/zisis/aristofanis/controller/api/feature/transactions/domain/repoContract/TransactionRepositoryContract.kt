package zisis.aristofanis.controller.api.feature.transactions.domain.repoContract

import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto

interface TransactionRepositoryContract {

    suspend fun createTransaction(transactionDto: TransactionDto)

    suspend fun updateTransactionStatus()

    suspend fun claimTransactionAsContributor()

    suspend fun cancelTransaction()

    suspend fun reportTransaction()

    suspend fun addContactInfoToTransaction()

    suspend fun createTransactionShareArea()

    suspend fun updateItem()

    suspend fun addCommentToTransaction()

    suspend fun updateHandshake()


}