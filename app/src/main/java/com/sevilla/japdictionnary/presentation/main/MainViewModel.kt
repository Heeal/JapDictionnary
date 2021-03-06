package com.sevilla.japdictionnary.presentation.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevilla.japdictionnary.domain.entity.Kanji
import com.sevilla.japdictionnary.domain.entity.Meanings
import com.sevilla.japdictionnary.domain.entity.Readings
import com.sevilla.japdictionnary.domain.usecase.createKanjiListUseCase
import com.sevilla.japdictionnary.domain.usecase.getKanjiUseCase
import com.sevilla.japdictionnary.domain.usecase.getStoredKanjiUseCase
import com.sevilla.japdictionnary.domain.usecase.storeKanjiUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createKanjiListUseCase: createKanjiListUseCase,
    private val getKanjiUseCase: getKanjiUseCase,
    private val storeKanjiUseCase: storeKanjiUseCase,
    private val getStoredKanjiUseCase: getStoredKanjiUseCase
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
        viewModelScope.launch() {
            _dataset.value = createKanjiListUseCase.invoke(search)!!
            /*val read = ArrayList<Readings>()
            read.add(Readings("こ"))

            val sense_arr = ArrayList<Meanings>()
            val sense = ArrayList<String>()
            sense.add("child")
            sense_arr.add(Meanings(sense))

            storeKanjiUseCase.invoke(Kanji("子", japanese = read, senses = sense_arr))
            delay(1000)
            var Kanji = getKanjiUseCase.getByKanji("子") */
        }
    }

    fun onSaveClick(item : Kanji){
        viewModelScope.launch(Dispatchers.IO) {
            storeKanjiUseCase.invoke(item)
        }
    }

    fun showMyList() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataset.postValue(getStoredKanjiUseCase.invoke())
        }
    }

}