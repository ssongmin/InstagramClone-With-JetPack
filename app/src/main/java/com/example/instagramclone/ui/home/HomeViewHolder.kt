package com.example.instagramclone.ui.home

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.model.PostDTO
import kotlinx.android.synthetic.main.item_layout_home_post.view.*

class HomeViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView){

    var data: PostDTO? = null
    var context: Context? = null
    init {
        this.context = context
    }

    fun bind(data: PostDTO) {
        this.data = data
        itemView.item_home_profile_user_id.text = data.user_id
        itemView.item_home_content_text.text = data.post_content
        itemView.item_home_favorite_cnt.text = data.favoriteCount
        Glide.with(context!!).load(data.post_image).into(itemView.item_home_content_image)
    }


}