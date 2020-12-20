package com.sevilla.japdictionnary.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevilla.japdictionnary.domain.usecase.createKanjiListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val createKanjiListUseCase: createKanjiListUseCase
): ViewModel(){
    fun onStart(){
        viewModelScope.launch {
            createKanjiListUseCase.invoke()
        }
    }
}