package org.keylane

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.response.respondText
import io.ktor.routing.*
import kotlinx.html.*


fun main(args : Array<String>) {
    JenkinsIO().getJenkinsNodes()
}

fun Application.main() {
    install(DefaultHeaders)
//    install(CallLogging)
    install(Routing) {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Header Title" }
                }
                body {
                    p { +"Hello world" }
                    h1 { +"Sample application with HTML builders" }
                }
            }
        }
        get("/test") {
            call.respondText(JenkinsIO().getJenkinsNodes().toString())
        }
    }
}

@HtmlTagMarker
fun FlowContent.widget(body: FlowContent.() -> Unit) {
    div { body() }
}