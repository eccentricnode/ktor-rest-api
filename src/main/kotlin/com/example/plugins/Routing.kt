package com.example.plugins

import com.example.routes.indexRouting
import com.example.routes.todosRouting
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import jdk.javadoc.internal.doclets.formats.html.markup.Head

fun Application.configureRouting() {
    routing {
        staticResources("/static", "assets")
        todosRouting()
        indexRouting()
    }
}

fun Head.commonHead() {
    title("Htmx-demo")
    script(src = "/static/htmx.min.js") {}
}