package com.sevilla.japdictionnary.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevilla.japdictionnary.domain.entity.Kanji
import com.sevilla.japdictionnary.domain.entity.Meanings
import com.sevilla.japdictionnary.domain.entity.Readings
import com.sevilla.japdictionnary.domain.usecase.createKanjiListUseCase
import com.sevilla.japdictionnary.domain.usecase.getKanjiUseCase
import com.sevilla.japdictionnary.domain.usecase.storeKanjiUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createKanjiListUseCase: createKanjiListUseCase,
    private val getKanjiUseCase: getKanjiUseCase,
    private val storeKanjiUseCase: storeKanjiUseCase
): ViewModel(){

    private var _dataset = MutableLiveData<ArrayList<Kanji>>()
    fun dataset(): LiveData<ArrayList<Kanji>> {
        return _dataset
    }
    fun onStart(){
        viewModelScope.launch {
            _dataset.postValue(createKanjiListUseCase.invoke("n5")!!)
        }
    }

    fun search(search : String){
        viewModelScope.launch(Dispatchers.IO) {
            //_dataset.value = createKanjiListUseCase.invoke(search)!!
            val read = ArrayList<Readings>()
            read.add(Readings("こ"))

            val sense_arr = ArrayList<Meanings>()
            val sense = ArrayList<String>()
            sense.add("child")
            sense_arr.add(Meanings(sense))

            storeKanjiUseCase.invoke(Kanji("子", japanese = read, senses = sense_arr))
            delay(1000)
            var Kanji = getKanjiUseCase.getByKanji("子")
            print(Kanji)
        }
    }
}