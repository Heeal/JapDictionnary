package com.sevilla.japdictionnary.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevilla.japdictionnary.domain.entity.Kanji
import com.sevilla.japdictionnary.domain.usecase.createKanjiListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val createKanjiListUseCase: createKanjiListUseCase
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
        viewModelScope.launch {
            _dataset.value = createKanjiListUseCase.invoke(search)!!
            print("aa")
        }
    }
}