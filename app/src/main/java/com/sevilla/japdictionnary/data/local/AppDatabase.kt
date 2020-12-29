package com.sevilla.japdictionnary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sevilla.japdictionnary.data.local.models.KanjiLocal

@Database(entities = arrayOf(KanjiLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDAO(): DatabaseDAO
}