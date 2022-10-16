package com.example.routes

import com.example.model.ApiResponse
import com.example.repository.HeroesRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {

    val heroRepository: HeroesRepository by inject()

    get("/workbench/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)   //throws exception if page is not in given interval

            val response = heroRepository.getAllHeroes(page)
            call.respond(
                HttpStatusCode.OK,
                response
            )
        } catch (e: NumberFormatException) {
            call.respond(
                HttpStatusCode.BadRequest,
                ApiResponse(success = false, message = "Only numbers allowed!")
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                HttpStatusCode.NotFound,
                ApiResponse(success = false, message = "Heroes not found!")
            )
        }
    }
}