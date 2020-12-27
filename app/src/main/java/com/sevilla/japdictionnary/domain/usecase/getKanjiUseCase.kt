package com.sevilla.japdictionnary.domain.usecase

import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.entity.Kanji

class getKanjiUseCase(
    private val kanjiRepository: KanjiRepository
) {
    suspend fun getByKanji(slug: String) : Kanji{
        return kanjiRepository.getKanji(slug)
    }
}