package com.example.inheritance

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf(
            ShoppingItem(android.R.color.holo_purple, "Lizards"),
            GroceryItem(productName = "Mango", isPerishable = true),
            ClothingItem(productName = "Batman Shirt", size = "X-Large"),
            EntertainmentItem(productName = "Laser pointer that shoots really really far", moreThanTenDollars = true)
        )

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ShoppingItemRecycler(list)


    }
}
