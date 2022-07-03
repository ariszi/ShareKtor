package zisis.aristofanis.controller.api.core.data

import org.litote.kmongo.coroutine.CoroutineFindPublisher
import zisis.aristofanis.controller.api.core.domain.Result
import zisis.aristofanis.controller.api.core.domain.runSuspendCatching

suspend fun <T : Any> CoroutineFindPublisher<T>.toResult(): Result<T> {
    val result = this.first()
    return runSuspendCatching { (result ?: throw GenericException)  }
}


