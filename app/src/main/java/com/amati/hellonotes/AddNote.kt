package com.amati.hellonotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.amati.hellonotes.Model.NotesViewModel
import com.amati.hellonotes.data.Note
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNote : AppCompatActivity() {
    lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            NotesViewModel::class.java)

        btnDone.setOnClickListener {
            val txtTittle = addTittle.text.toString()
            val mNote = addNote.text.toString()
            if(addNote.text.isNotEmpty()){
                viewModel.insertNote(Note(txtTittle,mNote))
                Toast.makeText(this, "${txtTittle}+Inserted", Toast.LENGTH_SHORT).show()
            }
        }


    }
}