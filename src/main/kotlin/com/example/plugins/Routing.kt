package com.example.plugins

import com.example.routes.indexRouting
import com.example.routes.todosRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        todosRouting()
        indexRouting()
    }
}
