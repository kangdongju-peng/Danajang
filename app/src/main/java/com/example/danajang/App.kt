package com.example.danajang

import android.app.Application

class App : Application() {
    companion object{
        lateinit var prefs : MySharedPreference
    }

    override fun onCreate() {
        prefs = MySharedPreference(applicationContext)
        super.onCreate()
    }


}