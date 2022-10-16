package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respond(
                status,
                "Page not found!"
            )
        }
//        exception<AuthenticationException> { call, cause ->
//            call.respond(
//                HttpStatusCode.OK,
//                "An error occurred! Check $cause"
//            )
//        }
    }
}