package com.example.group4_comp304_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class SemiDetached : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semi_detached)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.apartment -> {
                val intent = Intent(this, Apartments::class.java)
                startActivity(intent)
                true
            }

            R.id.detached -> {
                val intent = Intent(this, DetachedHomes::class.java)
                startActivity(intent)
                true
            }

            R.id.semi -> {
                val intent = Intent(this, SemiDetached::class.java)
                startActivity(intent)
                true
            }

            R.id.condo -> {
                val intent = Intent(this, Condo::class.java)
                startActivity(intent)
                true
            }

            R.id.town -> {
                val intent = Intent(this, TownHouse::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}