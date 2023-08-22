package com.example.islamy.ui.home.fragments.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemHadethNameBinding
import com.example.islamy.ui.model.Hadeth

class HadethRecyclerView(private var items:List<Hadeth>?)
    : RecyclerView.Adapter<HadethRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethNameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.hadethName.text = items!![position].title
        if(onItemClickListener!=null){
            holder.viewBinding.root.setOnClickListener{
                onItemClickListener?.onItemClick(position, items!![position])
            }
        }
    }

    override fun getItemCount(): Int = items?.size?:0

    fun bindItems(list: List<Hadeth>){
        items = list
        notifyDataSetChanged()
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener{
        fun onItemClick(position: Int, item: Hadeth)
    }


    class ViewHolder(val viewBinding: ItemHadethNameBinding)
        :RecyclerView.ViewHolder(viewBinding.root){
    }
}