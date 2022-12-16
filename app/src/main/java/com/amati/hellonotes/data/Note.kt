package com.amati.hellonotes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note (
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "Des") val Des : String,
){
    @PrimaryKey(autoGenerate = true) var id : Int = 0

}