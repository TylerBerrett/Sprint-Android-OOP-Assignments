package com.example.inheritance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_card_view.view.*

class ShoppingItemRecycler(val items: ArrayList<ShoppingItem>): RecyclerView.Adapter<ShoppingItemRecycler.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.background.background = ContextCompat.getDrawable(holder.background.context, items[position].colorId)
        holder.productName.text = items[position].productName
        holder.displayName.text = items[position].getDisplayName()

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val background = view.linear_layout_of_shopping_item
        val productName = view.tv_product_name
        val displayName = view.tv_product_display_name

    }

}