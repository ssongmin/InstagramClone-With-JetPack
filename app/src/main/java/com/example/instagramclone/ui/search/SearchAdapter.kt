package com.example.instagramclone.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.PostDTO

class SearchAdapter(context: Context) : RecyclerView.Adapter<SearchViewHolder>() {

    var context: Context = context

    private var datas: MutableList<PostDTO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val viewHolder = SearchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_search_post, parent, false), context
        )

        return viewHolder
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        datas?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return datas?.size ?: 0
    }

    fun setData(data: List<PostDTO>) {
        this.datas = data.toMutableList()
        notifyDataSetChanged()
    }

    fun addData(data: List<PostDTO>) {
        this.datas!!.addAll(data)
        notifyDataSetChanged()
    }
}