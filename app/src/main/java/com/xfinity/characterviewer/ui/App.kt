package com.xfinity.characterviewer.ui

import android.app.Application
import com.xfinity.characterviewer.R


class App : Application() {

    companion object {
        lateinit var appInstance: App
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    fun getApiEndPoint(): String = resources.getString(R.string.api_end_point)
}