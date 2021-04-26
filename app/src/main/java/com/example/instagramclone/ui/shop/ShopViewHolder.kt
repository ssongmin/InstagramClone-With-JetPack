package com.example.instagramclone.ui.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.R
import com.example.instagramclone.model.ShopDTO
import com.example.instagramclone.ui.search.SearchViewHolder
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import kotlinx.android.synthetic.main.item_layout_shop_product.view.*

class ShopViewHolder (itemView: View, context: Context) : RecyclerView.ViewHolder(itemView){
    var data: ShopDTO? = null
    var context: Context? = null

    init {
        this.context = context
    }

    fun bind(data: ShopDTO) {
        this.data = data
        itemView.item_shop_product_text.text = data.shopName
        Glide.with(context!!).load(data.shopImage).into(itemView.item_shop_product_image)

    }

    fun getClickObserver(): Observable<ShopDTO> {
        return Observable.create { emitter: ObservableEmitter<ShopDTO> ->
            itemView.setOnClickListener {
                emitter.onNext(this.data)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): ShopViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_shop_product, parent, false)
            return ShopViewHolder(view, parent.context)
        }
    }
}