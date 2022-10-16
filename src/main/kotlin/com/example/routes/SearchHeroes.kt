package com.example.routes

import com.example.repository.HeroesRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {


    val heroesRepository: HeroesRepository by inject()

    get("/workbench/heroes/search") {

        val name = call.request.queryParameters["name"]

        val apiResponse = heroesRepository.searchHero(name)
        call.respond(
            HttpStatusCode.OK,
            apiResponse
        )
    }
}