package com.xfinity.characterviewer.network

import com.xfinity.characterviewer.model.Names
import com.xfinity.characterviewer.ui.App
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//http://api.duckduckgo.com/?q=simpsons+characters&format=json


    @GET("/")
    fun getCharacterList(@Query("q", encoded = true) q: String = App.appInstance.getApiEndPoint()
                       , @Query("format") format: String = "json"): Observable<Names>

}

