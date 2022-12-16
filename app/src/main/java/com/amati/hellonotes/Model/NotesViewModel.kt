package com.amati.hellonotes.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.amati.hellonotes.data.Note
import com.amati.hellonotes.data.NoteDatabase
import com.amati.hellonotes.data.NoteRepository

class NotesViewModel(application: Application): AndroidViewModel(application) {
    val allNotes: LiveData<List<Note>>

    init {

        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }
}