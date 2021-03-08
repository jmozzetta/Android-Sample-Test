package com.example.userapplication

import android.app.Application
import com.example.userapplication.repository.UserDatabase

class UserApplication : Application() {

    companion object {
        lateinit var context: UserApplication
    }


    override fun onCreate() {
        super.onCreate()
        context = this
        var database = UserDatabase.getDatabase(context)
    }
}