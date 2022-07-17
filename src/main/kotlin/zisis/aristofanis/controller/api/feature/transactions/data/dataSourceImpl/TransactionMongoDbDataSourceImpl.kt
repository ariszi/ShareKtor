package zisis.aristofanis.controller.api.feature.transactions.data.dataSourceImpl

import org.litote.kmongo.coroutine.CoroutineCollection
import zisis.aristofanis.controller.api.feature.transactions.data.dataSourceContract.TransactionMongoDbDataSource
import zisis.aristofanis.controller.api.feature.user.data.models.User


class TransactionMongoDbDataSourceImpl(private val userCollection: CoroutineCollection<User>) :
    TransactionMongoDbDataSource {


}