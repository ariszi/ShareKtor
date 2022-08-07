package zisis.aristofanis.controller.api.core.data

import com.mongodb.client.result.InsertOneResult
import org.litote.kmongo.coroutine.CoroutineFindPublisher
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.runSuspendCatching

suspend fun <T : Any> CoroutineFindPublisher<T>.toResult(): Result<T> {
    val result = this.first()
    return runSuspendCatching { result ?: throw GenericException }
}

suspend fun InsertOneResult.toResult(): Result<InsertInMongoResult> {
    return runSuspendCatching {
        InsertInMongoResult(
            resultId = this.insertedId?.toString() ?: "",
            wasAcknowledged = this.wasAcknowledged()
        )
    }
}

data class InsertInMongoResult(val resultId: String, val wasAcknowledged: Boolean)


