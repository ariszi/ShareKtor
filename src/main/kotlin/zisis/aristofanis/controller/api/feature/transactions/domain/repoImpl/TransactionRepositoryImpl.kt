package zisis.aristofanis.controller.api.feature.transactions.domain.repoImpl

import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.presentation.responses.SimpleResponse
import zisis.aristofanis.controller.api.core.presentation.responses.State
import zisis.aristofanis.controller.api.feature.transactions.data.dataSourceContract.TransactionMongoDataSource
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto
import zisis.aristofanis.controller.api.feature.transactions.domain.repoContract.TransactionRepositoryContract


class TransactionRepositoryImpl(
    private val transactionMongoDataSource: TransactionMongoDataSource
) :
    TransactionRepositoryContract {
    override suspend fun createTransaction(transactionDto: TransactionDto): SimpleResponse {
        return when (transactionMongoDataSource.createTransaction(transactionDto)) {
            is Result.Success -> SimpleResponse(message = "Transaction created successfully")
            is Result.Error -> SimpleResponse(status = State.FAILED, message = "Error creating transaction")
        }
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


