package com.sevilla.japdictionnary.domain.entity


data class Kanji(
    val slug: String,
    val japanese: ArrayList<Readings>,
    val senses: ArrayList<Meanings>
)