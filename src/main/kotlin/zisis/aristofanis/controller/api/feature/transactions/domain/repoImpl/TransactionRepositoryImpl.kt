package zisis.aristofanis.controller.api.feature.transactions.domain.repoImpl

import org.litote.kmongo.coroutine.CoroutineCollection
import zisis.aristofanis.controller.api.feature.transactions.data.dataSourceContract.TransactionMongoDataSource
import zisis.aristofanis.controller.api.feature.transactions.data.models.Transaction
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto
import zisis.aristofanis.controller.api.feature.transactions.domain.repoContract.TransactionRepositoryContract


class TransactionRepositoryImpl(
    private val transactionCollection: CoroutineCollection<Transaction>,
    private val transactionMongoDataSource: TransactionMongoDataSource
) :
    TransactionRepositoryContract {
    override suspend fun createTransaction(transactionDto: TransactionDto) {
        TODO("Not yet implemented")
    }

    override suspend fun updateTransactionStatus() {
        TODO("Not yet implemented")
    }

    override suspend fun claimTransactionAsContributor() {
        TODO("Not yet implemented")
    }

    override suspend fun cancelTransaction() {
        TODO("Not yet implemented")
    }

    override suspend fun reportTransaction() {
        TODO("Not yet implemented")
    }

    override suspend fun addContactInfoToTransaction() {
        TODO("Not yet implemented")
    }

    override suspend fun createTransactionShareArea() {
        TODO("Not yet implemented")
    }

    override suspend fun updateItem() {
        TODO("Not yet implemented")
    }

    override suspend fun addCommentToTransaction() {
        TODO("Not yet implemented")
    }

    override suspend fun updateHandshake() {
        TODO("Not yet implemented")
    }

}


