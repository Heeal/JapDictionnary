package com.sevilla.japdictionnary.presentation.main

import RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevilla.japdictionnary.R
import com.sevilla.japdictionnary.domain.entity.Kanji
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.onStart()
        mainViewModel.dataset().observe(this, Observer {
            kanji_recycler_view.layoutManager = LinearLayoutManager(this)
            kanji_recycler_view.adapter = RecyclerViewAdapter(mainViewModel.dataset())
        })
    }

}