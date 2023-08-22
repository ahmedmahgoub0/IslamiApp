package com.example.islamy.ui.home.fragments.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemChapterNameBinding

class ChapterNameRecyclerView(private val names:List<String>)
    : RecyclerView.Adapter<ChapterNameRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChapterNameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.suraName.text = names[position]
        holder.viewBinding.suraNumber.text = ""+(position+1)
        if(onItemClickListener!=null){
            holder.viewBinding.root.setOnClickListener{
                onItemClickListener?.onItemClick(position, names[position])
            }
        }
    }

    override fun getItemCount(): Int = names.size

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener{
        fun onItemClick(position: Int, name: String)
    }


    class ViewHolder(val viewBinding: ItemChapterNameBinding)
        :RecyclerView.ViewHolder(viewBinding.root){
    }
}