package com.example.group4_comp304_lab2

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class PropertyListing : AppCompatActivity(){
    private lateinit var propertyRecyclerView: RecyclerView
    private lateinit var propertyArrayList: ArrayList<Property>
    private lateinit var selectedPropertyArrayList: ArrayList<Property>
    lateinit var checkBoxText: Array<String>
    lateinit var imageId: Array<Int>
    lateinit var price: Array<String>
    lateinit var i: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.house_list)

        propertyRecyclerView = findViewById(R.id.recyclerView)
        propertyRecyclerView.layoutManager = LinearLayoutManager(this)
        propertyRecyclerView.setHasFixedSize(true)

        propertyArrayList = arrayListOf()
        selectedPropertyArrayList= arrayListOf()

        var type = intent.getStringExtra("type")
        if (type == "apartment"){
            imageId = arrayOf(R.drawable.apartment1,R.drawable.apartment2,R.drawable.apartment3,R.drawable.apartment4)
            checkBoxText = arrayOf(getString(R.string.apt1title),getString(R.string.apt2title),
                getString(R.string.apt3title), getString(R.string.apt4title))
            price = arrayOf(getString(R.string.apt1price),getString(R.string.apt2price)
                ,getString(R.string.apt3price), getString(R.string.apt4price))

            getPropertyData()

        }
        else if(type =="detached"){
            imageId = arrayOf( R.drawable.detached1,R.drawable.detached2,R.drawable.detached3,R.drawable.detached4)
            checkBoxText = arrayOf(getString(R.string.det1title),getString(R.string.det2title),
                getString(R.string.det3title), getString(R.string.det4title))
            price = arrayOf(getString(R.string.det1price),getString(R.string.det2price)
                ,getString(R.string.det3price), getString(R.string.det4price))

            getPropertyData()

        }
        else if(type =="condo"){
            imageId = arrayOf( R.drawable.condo1,R.drawable.condo2,R.drawable.condo3,
                R.drawable.condo4)
            checkBoxText = arrayOf(getString(R.string.condo1title),getString(R.string.condo2title),
                getString(R.string.condo3title), getString(R.string.condo4title))
            price = arrayOf(getString(R.string.condo1price),getString(R.string.condo2price)
                ,getString(R.string.condo3price), getString(R.string.condo4price))

            getPropertyData()

        }
        else if(type =="semi"){
            imageId = arrayOf( R.drawable.semi1,R.drawable.semi2)
            checkBoxText = arrayOf(getString(R.string.semi1title),getString(R.string.semi2title))
            price = arrayOf(getString(R.string.semi1price),getString(R.string.semi2price))

            getPropertyData()

        }
        else if(type =="town"){
            imageId = arrayOf( R.drawable.town1,R.drawable.town2,R.drawable.town3)
            checkBoxText = arrayOf(getString(R.string.town1title),getString(R.string.town2title),
                getString(R.string.town3title))
            price = arrayOf(getString(R.string.town1price),getString(R.string.town2price)
                ,getString(R.string.town3price))
            getPropertyData()

        }
        else{
            checkBoxText = arrayOf()

        }

    }

    private fun getPropertyData() {
        for ( i in checkBoxText.indices){
            val property = Property(imageId[i],checkBoxText[i],price[i])
            propertyArrayList.add(property)


        }
        propertyRecyclerView.adapter = PropertyAdapter(propertyArrayList)

    }



    fun checkOut(view: View){

        if (selectedPropertyArrayList.isEmpty()) {
            Toast.makeText(this, "Please select a property.", Toast.LENGTH_SHORT).show()
            return  // Exit the method when no property is selected
        }
        //propertyRecyclerView.adapter = PropertyAdapter(selectedPropertyArrayList)
        val intent = Intent(this, CheckOut::class.java)
        var properties: ArrayList<String> = arrayListOf()
        var prices: ArrayList<String> = arrayListOf()

        for (p in selectedPropertyArrayList){
            properties.add(p.checkBoxText)
            prices.add(p.price)
        }
        intent.putStringArrayListExtra("names",properties)
        intent.putStringArrayListExtra("prices",prices)

        startActivity(intent)

    }

    fun checkBoxListener(view: View){
        // Is the view now checked?
        val checked: Boolean = (view as CheckBox).isChecked

        // Check which checkbox was clicked
        when (view.id) {
            R.id.property_checkbox -> {
                if (checked) {
                    // Do something when the checkbox is checked
                    var property  = view.text.toString()

                    for (p in propertyArrayList) {
                        if (p.checkBoxText == property) {
                            selectedPropertyArrayList.add(p)
                            break
                        }
                    }

                } else {
                    // Do something when the checkbox is unchecked
                    var property  = view.text.toString()

                    for (p in propertyArrayList) {
                        if (p.checkBoxText == property) {
                            selectedPropertyArrayList.remove(p)
                            break
                        }
                    }
                }
            }
        }
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
                val intent = Intent(this, PropertyListing::class.java)
                intent.putExtra("type","apartment")
                startActivity(intent)
                true
            }

            R.id.detached -> {
                val intent = Intent(this, PropertyListing::class.java)
                intent.putExtra("type","detached")
                startActivity(intent)
                true
            }

            R.id.semi -> {
                val intent = Intent(this, PropertyListing::class.java)
                intent.putExtra("type","semi")
                startActivity(intent)
                true
            }

            R.id.condo -> {
                val intent = Intent(this, PropertyListing::class.java)
                intent.putExtra("type","condo")
                startActivity(intent)
                true
            }

            R.id.town -> {
                val intent = Intent(this, PropertyListing::class.java)
                intent.putExtra("type","town")
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

}