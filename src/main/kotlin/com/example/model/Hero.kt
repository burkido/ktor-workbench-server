package com.example.model

import kotlinx.serialization.Serializable


@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)
