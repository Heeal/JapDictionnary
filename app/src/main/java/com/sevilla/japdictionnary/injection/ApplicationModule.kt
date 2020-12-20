package com.sevilla.japdictionnary.injection

import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.usecase.getKanjiListUseCase
import com.sevilla.japdictionnary.presentation.main.MainViewModel
import org.koin.dsl.module

val presentationModule = module{
    factory{ MainViewModel() }
}

val domainModule = module{
    factory{ getKanjiListUseCase() }
}

val dataModule = module{
    single { KanjiRepository() }
}