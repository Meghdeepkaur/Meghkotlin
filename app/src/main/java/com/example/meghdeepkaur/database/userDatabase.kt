package com.example.meghdeepkaur.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class userDatabase {
     @PrimaryKey(autoGenerate = true)
     var id: Int=0
    @ColumnInfo(name="name")
    var name: String?= null
    @ColumnInfo(name="email")
    var email: String?= null
}