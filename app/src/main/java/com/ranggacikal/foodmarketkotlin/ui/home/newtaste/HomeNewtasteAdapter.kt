package com.ranggacikal.foodmarketkotlin.ui.home.newtaste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ranggacikal.foodmarketkotlin.Helpers.formatPrice
import com.ranggacikal.foodmarketkotlin.R
import com.ranggacikal.foodmarketkotlin.model.dummy.HomeVerticalModel
import kotlinx.android.synthetic.main.item_home_vertical.view.*

class HomeNewtasteAdapter (

    private val listData : List<HomeVerticalModel>,
    private val itemAdapterCallback : ItemAdapterCallback

        ) : RecyclerView.Adapter<HomeNewtasteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewtasteAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_vertical , parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeNewtasteAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: HomeVerticalModel, itemAdapterCallback: ItemAdapterCallback){

            itemView.apply {
                tvTitle.text = data.title
                rbFood.rating = data.rating
                tvPrice.formatPrice(data.price )
                Glide.with(context)
                    .load(data.src)
                    .into(ivPoster)

                itemView.setOnClickListener {
                    itemAdapterCallback.onClick(it, data)
                }
            }

        }
    }

    interface ItemAdapterCallback{
        fun onClick(v:View, data:HomeVerticalModel)
    }

}