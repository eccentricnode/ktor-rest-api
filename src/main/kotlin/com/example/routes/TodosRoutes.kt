package com.example.routes

import com.example.models.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.todosRouting() {
    route("/todos" ) {
        get {
            if (todoStorage.isNotEmpty()) {
                call.respond(todoStorage)
            } else {
                call.respondText("No todos found", status = HttpStatusCode.OK)
            }
        }
        get ("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing Id",
                status = HttpStatusCode.BadRequest
            )
            val todo =
                todoStorage.find { it.id == id } ?: return@get call.respondText(
                    "No todo with Id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(todo)
        }
        post {
            val todo = call.receive<Todo>()
            todoStorage.add(todo)
            call.respondText("Todo stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (todoStorage.removeIf { it.id == id }) {
                call.respondText("Todo removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not found", status = HttpStatusCode.NotFound)
            }
        }
    }
}