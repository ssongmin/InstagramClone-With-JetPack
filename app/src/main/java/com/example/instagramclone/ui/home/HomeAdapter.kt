package com.example.instagramclone.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.PostDTO

class HomeAdapter(context: Context) : RecyclerView.Adapter<HomeViewHolder>() {

    var context: Context = context

    private var datas : List<PostDTO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val viewHolder = HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_home_post, parent, false)
            ,context
        )

        return viewHolder
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        datas?.let {
            holder.bind(it[position])

        }
    }

    override fun getItemCount(): Int {
        return datas?.size?: 0
    }

    fun addData(data: List<PostDTO>){
        this.datas = data
        notifyDataSetChanged()
    }
}