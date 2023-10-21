package com.example.group4_comp304_lab2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class PaymentOptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_options_layout)

        val paymentRadioGroup: RadioGroup = findViewById(R.id.paymentRadioGroup)
        val continueButton: Button = findViewById(R.id.continueButton)

        continueButton.setOnClickListener {
            val selectedPaymentOptionId = paymentRadioGroup.checkedRadioButtonId
            if (selectedPaymentOptionId == -1) {
                // Handle no payment option selected
            } else {
                val selectedPaymentOption: RadioButton = findViewById(selectedPaymentOptionId)

                // Create an Intent to start the CreditCardInfoActivity
                val intent = Intent(this, CreditCardInfoActivity::class.java)

                // Pass the selected payment option as an extra to the next activity
                intent.putExtra("selectedPaymentOption", selectedPaymentOption.text.toString())

                startActivity(intent)
            }
        }
    }
}