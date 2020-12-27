package com.sevilla.japdictionnary.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sevilla.japdictionnary.domain.entity.Kanji
import com.sevilla.japdictionnary.domain.entity.Meanings
import com.sevilla.japdictionnary.domain.entity.Readings

@Entity
data class KanjiLocal(
    @ColumnInfo(name = "kanji") val kanji: String?,
    @ColumnInfo(name = "meaning") val meaning: String?,
    @ColumnInfo(name = "reading") val reading: String?
){
    @PrimaryKey(autoGenerate = true) var uid: Int?= null
}

fun Kanji.toData() : KanjiLocal{
    return KanjiLocal(
        kanji = this.slug,
        meaning = this.senses[0].english_definitions[0],
        reading = this.japanese[0].reading
    )
}

fun KanjiLocal.toEntity() : Kanji {
    val jap = ArrayList<Readings>()
    jap.add(this.reading!!.toReading())

    val senses = ArrayList<Meanings>()
    senses.add(this.meaning!!.toMeaning())
    return Kanji(
        japanese = jap,
        senses = senses,
        slug = this.kanji!!
    )
}

private fun String.toReading() : Readings{
    return Readings(
        reading = this
    )
}
private fun String.toMeaning() : Meanings{
    val senses = ArrayList<String>()
    senses.add(this)
    return Meanings(
        english_definitions = senses
    )
}
