package com.sevilla.japdictionnary.domain.usecase

import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.entity.Kanji
import kotlinx.coroutines.delay

class createKanjiListUseCase(
    private val kanjiRepository: KanjiRepository
){
    public suspend fun invoke() {
        kanjiRepository.createKanjiList();
    }
}