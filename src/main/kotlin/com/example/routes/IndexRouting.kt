package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title

fun Route.indexRouting() {
get("/") {
        call.respondHtml {
            head {
                title { +"Example"}
            }
            body {
                p {
                    +"Some text"
                }
            }
        }
    }
}
