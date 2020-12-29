package com.sevilla.japdictionnary.presentation.main

import RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevilla.japdictionnary.R
import com.sevilla.japdictionnary.domain.entity.Kanji
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.*
import kotlinx.coroutines.delay
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.onStart()

        val listener = object: RecyclerViewAdapter.CustomViewHolderListener {
            override fun onCustomItemClicked(item: Kanji) {
                Toast.makeText(applicationContext, "Added "+item.slug+" to your list", Toast.LENGTH_SHORT).show()
                mainViewModel.onSaveClick(item)
            }
        }

        mainViewModel.dataset().observe(this, Observer {
            kanji_recycler_view.layoutManager = LinearLayoutManager(this)
            kanji_recycler_view.adapter = RecyclerViewAdapter(mainViewModel.dataset(), listener)
        })

        search_button.setOnClickListener(){
            mainViewModel.search(search_input.text.toString())
        }

        my_list_button.setOnClickListener(){
            mainViewModel.showMyList()
        }
    }
}