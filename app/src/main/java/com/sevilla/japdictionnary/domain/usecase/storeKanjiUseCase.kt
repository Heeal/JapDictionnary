package com.sevilla.japdictionnary.domain.usecase

import com.sevilla.japdictionnary.data.local.models.toData
import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.entity.Kanji

class storeKanjiUseCase(
    private val kanjiRepository: KanjiRepository
) {
    suspend fun invoke(kanji: Kanji){
        kanjiRepository.insertKanji(kanji.toData())
    }
}