package com.sevilla.japdictionnary.injection

import android.content.Context
import androidx.room.Room
import com.sevilla.japdictionnary.data.kanjiService
import com.sevilla.japdictionnary.data.local.AppDatabase
import com.sevilla.japdictionnary.data.local.DatabaseDAO
import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.usecase.createKanjiListUseCase
import com.sevilla.japdictionnary.domain.usecase.getKanjiUseCase
import com.sevilla.japdictionnary.domain.usecase.getStoredKanjiUseCase
import com.sevilla.japdictionnary.domain.usecase.storeKanjiUseCase
import com.sevilla.japdictionnary.presentation.main.MainActivity
import com.sevilla.japdictionnary.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module{
    single { MainActivity() }
    factory{ MainViewModel(get(), get(), get(), get()) }
}

val domainModule = module{
    factory{ createKanjiListUseCase(get()) }
    factory { getKanjiUseCase(get()) }
    factory { storeKanjiUseCase(get()) }
    factory { getStoredKanjiUseCase(get()) }
}

val dataModule = module{
    single { KanjiRepository(get()) }
    single { createDatabase(androidContext())}
}

fun createDatabase(context: Context) : DatabaseDAO{
    val appDatabase = Room.databaseBuilder(
            context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDAO()
}