package com.amati.hellonotes.data

import androidx.lifecycle.LiveData

class NoteRepository(private val notesDao: NotesDao) {
    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()
    suspend fun insert(note: Note){
        notesDao.insert(note)
    }
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }
}