package com.example.instagramclone.ui.search

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.model.PostDTO
import kotlinx.android.synthetic.main.item_layout_search_post.view.*

class SearchViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView){

    var data: PostDTO? = null
    var context: Context? = null

    init {
        this.context = context
    }

    fun bind(data: PostDTO) {
        this.data = data
        Glide.with(context!!).load(data.post_image).into(itemView.item_search_post_image)
        itemView.setOnClickListener{view: View ->
            listener.let {
                it.onSearchViewHolderClick(view, data)
            }
        }
    }

    interface OnSearchViewHolderListener{
        fun onSearchViewHolderClick(view: View, data: PostDTO)
    }

    lateinit var listener: OnSearchViewHolderListener

    public fun setViewHolderListener(listener: OnSearchViewHolderListener) {
        this.listener = listener
    }
}