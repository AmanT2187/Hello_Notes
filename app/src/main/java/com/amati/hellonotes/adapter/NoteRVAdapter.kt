package com.amati.hellonotes.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.amati.hellonotes.Model.NotesViewModel
import com.amati.hellonotes.R
import com.amati.hellonotes.data.Note
import kotlin.random.Random

class NoteRVAdapter(private val context: Context, private val listener : INoteRVAdapter): RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Note>()
    private  val color = context.resources.getIntArray(R.array.noteColor)

        inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById<TextView>(R.id.txtTittle)
        val note: TextView = itemView.findViewById<TextView>(R.id.txtNote)
            val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
            val noteCard: CardView = itemView.findViewById(R.id.noteCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
        viewHolder.btnDelete.setOnClickListener{
            listener.onItemClicked(allNotes.get(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.title.text =currentNote.title
        holder.note.text= currentNote.Des
        holder.noteCard.setCardBackgroundColor(color[(color.indices).random()])
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