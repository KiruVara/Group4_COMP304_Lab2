package com.example.group4_comp304_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeTypes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_types)
    }

    fun openApt(view: View) {
        val intent = Intent(this,Apartments::class.java)
        startActivity(intent)
    }
    fun openDetached(view: View) {
        val intent = Intent(this,DetachedHomes::class.java)
        startActivity(intent)}
    fun openSemi(view: View) {
        val intent = Intent(this,SemiDetached::class.java)
        startActivity(intent)
    }
    fun openCondo(view: View) {
        val intent = Intent(this,Condo::class.java)
        startActivity(intent)
    }
    fun openTown(view: View) {
        val intent = Intent(this,TownHouse::class.java)
        startActivity(intent)
    }


}