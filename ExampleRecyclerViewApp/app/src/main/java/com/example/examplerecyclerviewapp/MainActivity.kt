package com.example.examplerecyclerviewapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.NullPointerException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ExampleAdapter.OnItemClickedListener {
    private var exampleList = generateDummyList(20)
    private val adapter = ExampleAdapter(exampleList, this)
    private var itemSelected : ExampleItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun insertItem(view : View){
        val index : Int = Random.nextInt(20)
        val drawable = when (index % 5){
            0-> R.drawable.ic_baseline_local_movies_24
            1-> R.drawable.ic_baseline_library_music_24
            2-> R.drawable.ic_baseline_android_24
            3-> R.drawable.ic_outline_bakery_dining_24
            4-> R.drawable.ic_outline_videogame_asset_24
            else-> R.drawable.ic_baseline_photo_24
        }
        val newItem = ExampleItem(
            drawable,
            "I'm the new item you created at $index",
            "At ${Date()}"
        )
        exampleList.add(index,newItem)
        adapter.notifyItemInserted(index)
    }

    fun deleteItem(view : View){
       if (itemSelected != null && exampleList.contains(itemSelected)) {
           val index = exampleList.indexOf(itemSelected)
           exampleList.remove(itemSelected)
           adapter.notifyItemRemoved(index)
       } else{
           try{
               Toast.makeText(this, itemSelected!!.firstText + " not in list", Toast.LENGTH_SHORT).show()
           }catch (ex : NullPointerException){
               Toast.makeText(this, "It's a null item", Toast.LENGTH_SHORT).show()
           }
       }
    }

    private fun generateDummyList(size :Int): ArrayList<ExampleItem>{
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size){
            val drawable = when (i % 5){
                0-> R.drawable.ic_baseline_local_movies_24
                1-> R.drawable.ic_baseline_library_music_24
                2-> R.drawable.ic_baseline_android_24
                3-> R.drawable.ic_outline_bakery_dining_24
                4-> R.drawable.ic_outline_videogame_asset_24
                else-> R.drawable.ic_baseline_photo_24
            }

            var j = i+1
            val item = ExampleItem(drawable,"Item $j", Date().toString())
            list+=item
        }
        return list
    }

    override fun onItemClick(position: Int) {

        itemSelected = exampleList[position]
        Toast.makeText(this, itemSelected!!.firstText + "selected", Toast.LENGTH_SHORT).show()
        itemSelected!!.firstText += "selected"
        adapter.notifyItemChanged(position)
    }
}