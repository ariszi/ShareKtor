package zisis.aristofanis.controller.api.feature.transactions.presentation

import io.ktor.server.auth.*
import io.ktor.server.routing.*
import zisis.aristofanis.controller.api.VERSION_1
import zisis.aristofanis.controller.api.feature.transactions.domain.repoContract.TransactionRepositoryContract
import zisis.aristofanis.controller.api.feature.transactions.presentation.resources.CreateTransactionResource

fun Route.transactionsRouting(repository: TransactionRepositoryContract){

    authenticate {

        route(VERSION_1){
            post<CreateTransactionResource> {  }
        }

    }

}