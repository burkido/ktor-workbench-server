package com.example.repository

import com.example.model.ApiResponse
import com.example.model.Hero
import com.example.utils.Constant

class HeroesRepositoryImpl : HeroesRepository {

    override val heroes: Map<Int, List<Hero>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }

    override val page1 = listOf(
        Hero(
            id = 1,
            name = "Sasuke",
            image = "/images/sasuke.png",
            about = "Sasuke about...",
            rating = 4.0,
            power = 90,
            family = listOf(
                "Fugaku",
                "Migoko"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        ),
        Hero(
            id = 2,
            name = "Amado",
            image = "/images/amado.png",
            about = "Amado about...",
            rating = 4.2,
            power = 90,
            family = listOf(
                "Sasuke",
                "Sharingan"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Amado nature types")
        ),
        Hero(
            id = 3,
            name = "Boruto",
            image = "/images/boruto.png",
            about = "Boruto about...",
            rating = 4.9,
            power = 30,
            family = listOf(
                "Fugaku",
                "Migoko"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        )
    )
    override val page2 = listOf(
        Hero(
            id = 4,
            name = "Code",
            image = "/images/code.png",
            about = "Code about...",
            rating = 3.2,
            power = 60,
            family = listOf(
                "about",
                "nature"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        ),
        Hero(
            id = 5,
            name = "Ishiki",
            image = "/images/ishiki.png",
            about = "Ishiki about...",
            rating = 4.2,
            power = 90,
            family = listOf(
                "Sasuke",
                "Sharingan"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Amado nature types")
        ),
        Hero(
            id = 6,
            name = "Kakashi",
            image = "/images/kakashi.png",
            about = "Kakashi about...",
            rating = 4.9,
            power = 30,
            family = listOf(
                "Fugaku",
                "Migoko"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        )

    )
    override val page3 = listOf(
        Hero(
            id = 7,
            name = "Kawaki",
            image = "/images/kawaki.png",
            about = "Code about...",
            rating = 4.2,
            power = 99,
            family = listOf(
                "about",
                "nature"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        ),
        Hero(
            id = 8,
            name = "Koji",
            image = "/images/koji.png",
            about = "Koji about...",
            rating = 2.2,
            power = 44,
            family = listOf(
                "Kawakş",
                "Sharingan"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Amado nature types")
        ),
        Hero(
            id = 9,
            name = "Mitsuki",
            image = "/images/mitsuki.png",
            about = "Mitsuki about...",
            rating = 3.3,
            power = 57,
            family = listOf(
                "Fugaku",
                "Migoko"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        )
    )
    override val page4 = listOf(
        Hero(
            id = 10,
            name = "Momoshiki",
            image = "/images/momoshiki.png",
            about = "Momoshiki about...",
            rating = 1.3,
            power = 19,
            family = listOf(
                "about",
                "nature"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        ),
        Hero(
            id = 11,
            name = "Naruto",
            image = "/images/naruto.png",
            about = "Naruto about...",
            rating = 5.0,
            power = 100,
            family = listOf(
                "Kawakş",
                "Sharingan"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Amado nature types")
        ),
        Hero(
            id = 12,
            name = "Orochi",
            image = "/images/orochimaru.png",
            about = "Orochi about...",
            rating = 4.2,
            power = 77,
            family = listOf(
                "Fugaku",
                "Migoko"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        )
    )
    override val page5 = listOf(
        Hero(
            id = 13,
            name = "Sakura",
            image = "/images/sakaura.png",
            about = "Sakura about...",
            rating = 4.2,
            power = 99,
            family = listOf(
                "about",
                "nature"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        ),
        Hero(
            id = 14,
            name = "Koji",
            image = "/images/koji.png",
            about = "Koji about...",
            rating = 2.2,
            power = 44,
            family = listOf(
                "Kawakş",
                "Sharingan"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Amado nature types")
        ),
        Hero(
            id = 15,
            name = "Urashiki",
            image = "/images/urashiki.png",
            about = "Urashiki about...",
            rating = 3.3,
            power = 57,
            family = listOf(
                "Fugaku",
                "Migoko"
            ),
            abilities = listOf("Sharingan Rinnegan"),
            natureTypes = listOf("Sasuke nature types")
        )
    )


    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            true,
            "Successfully responded",
            calculatePage(page)[Constant.PREV_PAGE],
            calculatePage(page)[Constant.NEXT_PAGE],
            heroes[page]!!
        )
    }

    private fun calculatePage(page: Int): Map<String, Int?> {

        var prevPage: Int? = page
        var nextPage: Int? = page

        if (page in 1..4)
            nextPage = nextPage?.plus(1)

        if (page in 2..5)
            prevPage = prevPage?.minus(1)

        if (page == 1)
            prevPage = null

        if (page == 5)
            nextPage = null

        return mapOf(
            Constant.PREV_PAGE to prevPage,
            Constant.NEXT_PAGE to nextPage
            )
    }

    override suspend fun searchHero(name: String?): ApiResponse {
        return ApiResponse(
            success = true,
            message = "Successfully responded",
            heroes = queryHero(name)
        )
    }

    private fun queryHero(query: String?): List<Hero> {

        val founded = mutableListOf<Hero>()
        
        return if (!query.isNullOrEmpty()) {
            heroes.forEach { (_, heroes) ->
                heroes.forEach { hero ->
                    if (hero.name.lowercase().contains(query.lowercase())) {
                        founded.add(hero)
                    }
                }
            }
            founded
        } else
            emptyList()

    }
}