package com.example.instagramclone.ui.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.ShopDTO


class ShopAdapter(context: Context) : RecyclerView.Adapter<ShopViewHolder>() {

    var context: Context = context

    private var datas: MutableList<ShopDTO>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
//        val viewHolder = ShopViewHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_layout_shop_product, parent, false), context
//        )
        return ShopViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        datas?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount(): Int {
        return datas?.size?:0
    }

    fun setData(data: List<ShopDTO>) {
        this.datas = data.toMutableList()
        notifyDataSetChanged()
    }
}