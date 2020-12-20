package com.sevilla.japdictionnary.data

import com.sevilla.japdictionnary.domain.entity.APIResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface kanjiService {
    @GET("words?keyword=n5")
    fun getKanjiFromLevel(): Call<APIResponse>
}