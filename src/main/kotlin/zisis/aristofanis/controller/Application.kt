package zisis.aristofanis.controller

import io.ktor.server.application.*
import io.ktor.server.netty.*
import zisis.aristofanis.controller.plugins.configPlugIns
import zisis.aristofanis.controller.plugins.configureRouting
import zisis.aristofanis.controller.plugins.plugin_configs.configureDatabase

fun main(args: Array<String>): Unit = EngineMain.main(args)
fun Application.mainModule() {
    val database = configureDatabase()
    configPlugIns(database)
    configureRouting(database)
}