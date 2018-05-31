package com.xfinity.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    internal val BASE_URL = "http://api.duckduckgo.com"

    internal lateinit var retrofit: Retrofit

    val retrofitInstance: Retrofit
        get() {
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

            return retrofit

        }
}
