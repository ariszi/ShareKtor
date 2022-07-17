package zisis.aristofanis.controller.api.feature.transactions.data.dataSourceImpl

import org.litote.kmongo.coroutine.CoroutineCollection
import zisis.aristofanis.controller.api.feature.transactions.data.dataSourceContract.TransactionMongoDbDataSource
import zisis.aristofanis.controller.api.feature.transactions.domain.models.TransactionDto
import zisis.aristofanis.controller.api.feature.user.data.models.User


class TransactionMongoDbDataSourceImpl(private val userCollection: CoroutineCollection<User>) :
    TransactionMongoDbDataSource {
    override fun createTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun updateTransactionStatus(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun claimTransactionAsContributor(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun cancelTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun reportTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun addContactInfoToTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun createTransactionShareArea(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun updateItem(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun addCommentToTransaction(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }

    override fun updateHandshake(): Result<TransactionDto> {
        TODO("Not yet implemented")
    }


}