package zisis.aristofanis.controller.api.feature.transactions.data.datasource_impl

import org.litote.kmongo.coroutine.CoroutineCollection
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.feature.transactions.data.datasource_contract.TransactionMongoDataSource
import zisis.aristofanis.controller.api.feature.transactions.data.models.Transaction
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto
import zisis.aristofanis.controller.api.feature.user.domain.UserExceptions


class TransactionMongoDataSourceImpl(private val transactionCollection: CoroutineCollection<Transaction>) :
    TransactionMongoDataSource {
    override suspend fun createTransaction(transactionDto: TransactionDto): Result<TransactionDto> {
        val insertResult = transactionCollection.insertOne(transactionDto.toMongoSchemaModel())
        insertResult.insertedId?.asString().toString()
        return if (insertResult.wasAcknowledged()) {
            Result.Success(transactionDto.copy(id = insertResult.insertedId?.toString() ?: ""))
        } else {
            UserExceptions.UserCreationException.toError()
        }
    }

    override suspend fun updateTransactionStatus(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun claimTransactionAsContributor(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun cancelTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun reportTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun addContactInfoToTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun createTransactionShareArea(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun updateItem(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun addCommentToTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override suspend fun updateHandshake(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }
}


