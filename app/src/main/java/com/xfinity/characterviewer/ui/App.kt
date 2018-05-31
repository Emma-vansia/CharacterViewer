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

    val isTablet: Boolean by lazy {
        this.resources.getBoolean(R.bool.is_tablet)
    }

    fun getCharacterType() = resources.getString(R.string.character_type)
}