package com.sevilla.japdictionnary.data

import com.sevilla.japdictionnary.domain.entity.APIResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface kanjiService {
    @GET("words")
    fun getKanjiFromSearch(@Query("keyword") search:String): Call<APIResponse>
}