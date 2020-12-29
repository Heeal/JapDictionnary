package com.sevilla.japdictionnary.domain.usecase

import com.sevilla.japdictionnary.data.local.DatabaseDAO
import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.entity.Kanji

class getStoredKanjiUseCase(
    private val kanjiRepository: KanjiRepository
) {
    suspend fun invoke() : ArrayList<Kanji> {
        return kanjiRepository.getAllKanji()
    }
}