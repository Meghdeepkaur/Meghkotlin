package com.example.meghdeepkaur.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MeghRoomDatabase: RoomDatabase() {
    abstract fun userDao(): userDao
    companion object{
        private var instance: MeghRoomDatabase?= null

        @Synchronized
        fun getDatabase(context: Context):MeghRoomDatabase{
            if (instance == null)
                instance= Room.databaseBuilder(
                    context.applicationContext,
                    MeghRoomDatabase:: class.java,
                    "Megh_database"
                ).build()
            return instance!!
        }
    }
}