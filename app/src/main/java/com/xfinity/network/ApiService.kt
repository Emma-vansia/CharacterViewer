package com.xfinity.network

import com.xfinity.characterviewer.model.Characters
import com.xfinity.characterviewer.ui.App
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//http://api.duckduckgo.com/?q=simpsons+characters&format=json


    @GET("/")
    fun getCharacterList(@Query("q", encoded = true) q: String = App.appInstance.getCharacterType()
                       , @Query("format") format: String = "json"): Call<Characters>

}

