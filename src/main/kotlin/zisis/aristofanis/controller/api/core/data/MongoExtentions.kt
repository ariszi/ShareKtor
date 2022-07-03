package zisis.aristofanis.controller.api.core.data

import org.litote.kmongo.MongoOperator
import org.litote.kmongo.coroutine.CoroutinePublisher
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.runSuspendCatching

inline fun <T : Any> CoroutinePublisher<T>.toResult(): Result<T> {
    return runSuspendCatching {
        MongoOperator.first as T
    }
}


