package com.example.group4_comp304_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class CheckOut : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup // Get the RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        radioGroup = findViewById<RadioGroup>(R.id.property_checkout_rg)
        val titles = intent.getStringArrayListExtra("names")
        val prices = intent.getStringArrayListExtra("prices")


        if (titles != null && prices !=null) {
            for ((index, title) in titles.withIndex()) {
                val radioButton = RadioButton(this) // Create a new RadioButton
                radioButton.id = View.generateViewId() // Generate a unique ID for the RadioButton
                radioButton.text = title + "\n"+ prices[index] // Set the text for the RadioButton

                val paddingInPixels = resources.getDimensionPixelSize(R.dimen.radio_button_padding)
                radioButton.setPadding(paddingInPixels, paddingInPixels, paddingInPixels, paddingInPixels)

                // Set layout parameters if necessary
                val params = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                )

                radioGroup.addView(radioButton, index, params) // Add the RadioButton to the RadioGroup
            }
        }


    }
    fun payment(view: View) {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        if (selectedRadioButtonId != -1) {
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedText = selectedRadioButton.text.toString()

            val intent = Intent(this, PaymentOptionsActivity::class.java)
            intent.putExtra("selectedProperty", selectedText)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please select a property to continue.", Toast.LENGTH_SHORT).show()
        }
    }
}