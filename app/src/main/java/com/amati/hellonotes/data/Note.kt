package com.amati.hellonotes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "Des") val Des : String,

)