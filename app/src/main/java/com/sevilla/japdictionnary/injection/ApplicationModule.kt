package com.sevilla.japdictionnary.injection

import com.sevilla.japdictionnary.data.kanjiService
import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.usecase.createKanjiListUseCase
import com.sevilla.japdictionnary.presentation.main.MainViewModel
import org.koin.dsl.module

val presentationModule = module{
    factory{ MainViewModel(get()) }
}

val domainModule = module{
    factory{ createKanjiListUseCase(get()) }
}

val dataModule = module{
    single { KanjiRepository() }
}