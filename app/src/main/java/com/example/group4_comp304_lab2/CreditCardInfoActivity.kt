package com.example.group4_comp304_lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreditCardInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.credit_card_info_layout)

        val cardNumberEditText: EditText = findViewById(R.id.cardNumberEditText)
        val expirationDateEditText: EditText = findViewById(R.id.expirationDateEditText)
        val cvvEditText: EditText = findViewById(R.id.cvvEditText)
        val submitPaymentButton: Button = findViewById(R.id.submitPaymentButton)

        val selectedPaymentOption = intent.getStringExtra("selectedPaymentOption")

// Show credit card information fields only if the selected payment option is credit card or debit card
        if (selectedPaymentOption == "Credit Card" || selectedPaymentOption == "Debit Card") {
            cardNumberEditText.visibility = EditText.VISIBLE
            expirationDateEditText.visibility = EditText.VISIBLE
            cvvEditText.visibility = EditText.VISIBLE
        } else {
            cardNumberEditText.visibility = EditText.GONE
            expirationDateEditText.visibility = EditText.GONE
            cvvEditText.visibility = EditText.GONE
        }

        submitPaymentButton.setOnClickListener {
            val cardNumber = cardNumberEditText.text.toString()
            val expirationDate = expirationDateEditText.text.toString()
            val cvv = cvvEditText.text.toString()

            if (selectedPaymentOption == "Cash") {
                // Handle cash payment logic here
            } else if (selectedPaymentOption == "Credit Card" || selectedPaymentOption == "Debit Card") {
                // Handle credit/debit card payment logic here
            }

            // You can navigate to a confirmation screen or perform other actions as needed.
        }
    }
}