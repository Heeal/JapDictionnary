package com.sevilla.japdictionnary.domain.usecase

import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sevilla.japdictionnary.R
import com.sevilla.japdictionnary.data.repository.KanjiRepository
import com.sevilla.japdictionnary.domain.entity.Kanji
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class createKanjiListUseCase(
    private val kanjiRepository: KanjiRepository
){
    suspend fun invoke(): ArrayList<Kanji>?{
        kanjiRepository.createKanjiList();
        var i : Long = 0
        while(i<200){
            delay(1000)
            if(kanjiRepository.done){
                return kanjiRepository.kanjiList
            }
            i++
        }
        return null
    }

}