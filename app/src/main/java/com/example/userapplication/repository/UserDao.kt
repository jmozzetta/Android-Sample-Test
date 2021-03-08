package com.example.userapplication.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userapplication.models.User

@Dao
interface UserDao {

    @Query("SELECT COUNT(*) FROM users")
    fun count(): Int

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(users: List<User>)
}