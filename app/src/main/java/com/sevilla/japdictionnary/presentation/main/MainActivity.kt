package com.sevilla.japdictionnary.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sevilla.japdictionnary.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.onStart()
    }
}