package com.example.userapplication.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userapplication.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "users.db"

        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, UserDatabase::class.java, DATABASE_NAME).allowMainThreadQueries().build()
                INSTANCE!!.populateDatabase(context)
            }
            return INSTANCE!!
        }
    }

    private fun populateDatabase(context: Context) {
        if (userDao().count() == 0) {
            val file = context.assets.open("users.json").bufferedReader().use { it.readText() }

            val type = object : TypeToken<List<User>>() {}.type

            val users = Gson().fromJson<List<User>>(file, type)

            kotlin.run {
                userDao().addUsers(users)
            }
        }
    }
}