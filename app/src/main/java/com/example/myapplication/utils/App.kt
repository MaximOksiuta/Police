package com.example.myapplication.utils

import android.app.Application
import androidx.appcompat.app.AppCompatActivity

val sharedPrefs by lazy{
    SharedPrefs(App.instance)
}

class App: Application() {

    companion object{
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}