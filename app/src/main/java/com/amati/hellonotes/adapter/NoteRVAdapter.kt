package com.amati.hellonotes.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amati.hellonotes.Model.NotesViewModel
import com.amati.hellonotes.R
import com.amati.hellonotes.data.Note

class NoteRVAdapter(private val context: Context, private val listener : INoteRVAdapter): RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Note>()
        inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById<TextView>(R.id.txtTittle)
        val note: TextView = itemView.findViewById<TextView>(R.id.txtNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
        viewHolder.title.setOnClickListener{
            listener.onItemClicked(allNotes.get(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.title.text =currentNote.title
        holder.note.text= currentNote.Des
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: ArrayList<Note>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

}
interface INoteRVAdapter {
    fun onItemClicked(note: Note)
}