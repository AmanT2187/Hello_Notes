package com.amati.hellonotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.amati.hellonotes.Model.NotesViewModel
import com.amati.hellonotes.adapter.INoteRVAdapter
import com.amati.hellonotes.adapter.NoteRVAdapter
import com.amati.hellonotes.data.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INoteRVAdapter {
     lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNotes.layoutManager = GridLayoutManager(this, 2)
        val adapter = NoteRVAdapter(this, this)

        rvNotes.adapter = adapter


        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list ->
            list?.let {
                adapter.updateList(it as ArrayList<Note>)
            }
        })

        btnAdd.setOnClickListener{
            startActivity(Intent(this, AddNote::class.java))
        }
    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "${note.title}+Deleted", Toast.LENGTH_SHORT).show()
    }
}