package com.amati.hellonotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.amati.hellonotes.Model.NotesViewModel
import com.amati.hellonotes.data.Note
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.note_item.*

class AddNote : AppCompatActivity() {

    lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            NotesViewModel::class.java)

        val bundle: Bundle? = intent.extras
        val eTittle = bundle?.get("tittle")
        val eNote = bundle?.get("note")

        if(eNote.toString() == "null"){
            addTittle.setText("")
            addNote.setText("")
        }else{
        addTittle.setText(eTittle.toString())
        addNote.setText(eNote.toString())

        }


        btnDone.setOnClickListener {
//            val txtTittle = addTittle.text.toString()
//            val mNote = addNote.text.toString()
//            if(addNote.text.isNotEmpty()){
//                viewModel.insertNote(Note(txtTittle,mNote))
//                Toast.makeText(this, "${txtTittle}+Inserted", Toast.LENGTH_SHORT).show()
//
//            }
            onBackPressed()
        }


    }

    override fun onBackPressed() {
        val txtTittle = addTittle.text.toString()
        val mNote = addNote.text.toString()
        if(addNote.text.isNotEmpty()){
            viewModel.insertNote(Note(txtTittle,mNote))
//            Toast.makeText(this, "$txtTittle Inserted", Toast.LENGTH_SHORT).show()

        }
        super.onBackPressed()
    }
}