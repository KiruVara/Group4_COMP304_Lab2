package com.example.group4_comp304_lab2

import android.content.Intent
import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class HomeTypes : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_types)
    }

    fun openApt(view: View) {
        val intent = Intent(this,PropertyListing::class.java)
        intent.putExtra("type","apartment")
        startActivity(intent)
    }
    fun openDetached(view: View) {
        val intent = Intent(this,PropertyListing::class.java)
        intent.putExtra("type","detached")
        startActivity(intent)}
    fun openSemi(view: View) {
        val intent = Intent(this,PropertyListing::class.java)
        intent.putExtra("type","semi")
        startActivity(intent)
    }
    fun openCondo(view: View) {
        val intent = Intent(this,PropertyListing::class.java)
        intent.putExtra("type","condo")
        startActivity(intent)
    }
    fun openTown(view: View) {
        val intent = Intent(this,PropertyListing::class.java)
        intent.putExtra("type","town")
        startActivity(intent)
    }


}