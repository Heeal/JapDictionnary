package com.sevilla.japdictionnary.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sevilla.japdictionnary.data.local.models.KanjiLocal


@Dao
interface DatabaseDAO {
    @Query("SELECT * from KanjiLocal")
    fun getAll(): List<KanjiLocal>

    @Query("SELECT * from KanjiLocal WHERE uid LIKE :uid LIMIT 1")
    fun findById(uid: Int): KanjiLocal

    @Query("SELECT * from KanjiLocal WHERE kanji LIKE :slug LIMIT 1")
    fun findBySlug(slug : String): KanjiLocal

    @Insert
    fun insert(vararg kanji: KanjiLocal)

    @Delete
    fun delete(kanji: KanjiLocal)
}