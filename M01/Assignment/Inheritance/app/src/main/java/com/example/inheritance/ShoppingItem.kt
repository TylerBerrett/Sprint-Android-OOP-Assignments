package com.example.inheritance

open class ShoppingItem(val colorId: Int, val productName: String) {

    open fun getDisplayName(): String{
        return productName
    }
}

class GroceryItem(colorId: Int = android.R.color.holo_green_light, productName: String, isPerishable: Boolean): ShoppingItem(colorId, productName){
    val perishable = isPerishable

    override fun getDisplayName(): String {
        return when(perishable){
            true -> "$productName is perishable"
            else -> "$productName is not perishable"
        }
    }
}

class ClothingItem(colorId: Int = android.R.color.holo_red_light, productName: String, size: String): ShoppingItem(colorId, productName){
    val clothingSize = size

    override fun getDisplayName(): String {
        return when(clothingSize.toLowerCase()){
            "large" -> "$productName in size large"
            "medium" -> "$productName in a medium size"
            "small" -> "$productName in the size of small"
            else -> "Sorry we are too poor to carry $productName in that size"
        }
    }

}

class EntertainmentItem(colorId: Int = android.R.color.holo_blue_light, productName: String, moreThanTenDollars: Boolean): ShoppingItem(colorId, productName){
    val entertainmentPrice = moreThanTenDollars

    override fun getDisplayName(): String {
        return when(entertainmentPrice){
            true -> "go return the item with the name of $productName"
            else -> "eh I guess you can keep the $productName"
        }
    }


}