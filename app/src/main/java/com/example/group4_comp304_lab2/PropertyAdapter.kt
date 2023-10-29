package com.example.group4_comp304_lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PropertyAdapter(private val propertyList: ArrayList<Property>) : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)
        return PropertyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return propertyList.size
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val currentItem = propertyList[position]
        holder.image.setImageResource(currentItem.image)
        holder.checkBox.text = currentItem.checkBoxText
        holder.price.text = currentItem.price
    }

    class PropertyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.property_image)
        var checkBox: TextView = itemView.findViewById(R.id.property_checkbox)
        var price: TextView = itemView.findViewById(R.id.property_price)
    }

}