package com.example.islamy.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islamy.databinding.ActivityChapterDetailsBinding
import com.example.islamy.databinding.ItemVerseBinding

class VersesAdapter(val verses:List<String>)
    :RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBiding.verse.text = verses[position]
    }

    override fun getItemCount(): Int = verses.size

    class ViewHolder(val viewBiding: ItemVerseBinding)
        :RecyclerView.ViewHolder(viewBiding.root){

    }
}