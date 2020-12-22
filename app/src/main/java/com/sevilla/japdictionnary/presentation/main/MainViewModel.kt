package com.sevilla.japdictionnary.presentation.main

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevilla.japdictionnary.R
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
    var done = false
    fun onStart(){
        viewModelScope.launch {
            _dataset.postValue(createKanjiListUseCase.invoke()!!)
           done = true
        }
    }
}