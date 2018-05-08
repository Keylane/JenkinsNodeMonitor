package org.keylane

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.HttpStatusCode
import io.ktor.routing.*
import kotlinx.html.*

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondHtml(HttpStatusCode.NotFound) {
                body {
                    h1 { +"Sample application with HTML builders" }
                }
            }
        }
    }
}

@HtmlTagMarker
fun FlowContent.widget(body: FlowContent.() -> Unit) {
    div { body() }
}