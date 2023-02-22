package com.example.meghdeepkaur.database

import androidx.room.*
import androidx.room.Insert
import androidx.room.OnConflictStrategy
@Dao
abstract class userDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(vararg user: userDatabase)
}