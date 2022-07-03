package zisis.aristofanis.controller.plugins.pluginconfigs

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun configureDatabase(): CoroutineDatabase {
    val client = KMongo.createClient().coroutine
    return client.getDatabase("share-db")
}