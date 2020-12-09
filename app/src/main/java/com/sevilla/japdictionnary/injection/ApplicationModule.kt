package com.sevilla.japdictionnary.injection

import com.sevilla.japdictionnary.MainViewModel
import org.koin.dsl.module

val presentationModule = module{

    factory{ MainViewModel() }

}