package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import java.time.Duration

/**
 * <p>
 * Add custom header to each response.
 * We are going to have a chance to cache the data from our Android application.
 * </p>
 */
fun Application.configureDefaultHeader() {
    install(DefaultHeaders) {
        val secondsInYear = Duration.ofDays(365).seconds
        header(
            name = HttpHeaders.CacheControl,
            value = "public, max-age=$secondsInYear, immutable"
        )
    }
}