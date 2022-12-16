package com.amati.hellonotes.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface NotesDao   {
@Query("SELECT * FROM note_table ORDER BY id ASC")
 fun getAllNotes(): LiveData<List<Note>>

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(note: Note)

@Delete
suspend fun delete(note: Note)
}