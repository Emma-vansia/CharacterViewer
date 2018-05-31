package com.xfinity.characterviewer.network

import com.xfinity.characterviewer.model.Characters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//http://api.duckduckgo.com/?q=simpsons+characters&format=json
    //http://rjtmobile.com/ansari/fos/fosapp/fos_food_loc.php?city=delhi

    @GET("/")
    fun getFoodDetails(@Query("q") q: String, @Query("format") format: String = "json"): Call<Characters>



}

