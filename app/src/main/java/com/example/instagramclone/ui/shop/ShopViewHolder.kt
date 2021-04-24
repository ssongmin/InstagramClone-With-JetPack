package com.example.instagramclone.ui.shop

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.model.ShopDTO
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

}