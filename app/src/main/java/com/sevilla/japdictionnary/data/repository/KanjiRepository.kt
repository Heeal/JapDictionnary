package com.sevilla.japdictionnary.data.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sevilla.japdictionnary.data.kanjiService
import com.sevilla.japdictionnary.domain.entity.APIResponse
import com.sevilla.japdictionnary.domain.entity.Kanji
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class KanjiRepository {
    var kanjiList = ArrayList<Kanji>()
    var done = false

    suspend fun createKanjiList(){

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jisho.org/api/v1/search/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val API = retrofit.create(kanjiService::class.java)
        val API_Request = API.getKanjiFromLevel()

        API_Request.enqueue(object : Callback<APIResponse> {
            override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                val allCourse = response.body()
                if (allCourse != null) {
                    kanjiList = allCourse.data
                    done = true
                }
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                done = false
                error("Failed")
            }
        })


    }

    suspend fun getKanjiList(): List<Kanji>? {
        return kanjiList
    }

}