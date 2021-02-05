package com.example.examplerecyclerviewapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExampleAdapter (
    private val exampleList : List<ExampleItem>,
    private val listener : OnItemClickedListener)
    : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView : ImageView = itemView.findViewById(R.id.imageExample)
        val firstTextView : TextView = itemView.findViewById(R.id.first_text_View)
        val secondTextView : TextView = itemView.findViewById(R.id.second_text_View)

        init {
            itemView.setOnClickListener (this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position !=  RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickedListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent,false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageRessource)
        holder.firstTextView.setText(currentItem.firstText)
        holder.secondTextView.setText(currentItem.secondText)
    }

    override fun getItemCount() = exampleList.size
}