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
                // No payment option selected
                // You can show an error message or handle it as needed.
            } else {
                val selectedPaymentOption: RadioButton = findViewById(selectedPaymentOptionId)

                // Depending on the selected payment option, you can perform actions here.
                when (selectedPaymentOption.id) {
                    R.id.cashRadioButton -> {
                        // Handle cash payment option
                    }
                    R.id.creditCardRadioButton -> {
                        // Handle credit card payment option
                    }
                    R.id.debitCardRadioButton -> {
                        // Handle debit card payment option
                    }
                }

                // You can also pass the selected payment option to the next screen/activity.
                val intent = Intent(this, PropertyListing::class.java)
                intent.putExtra("selectedPaymentOption", selectedPaymentOption.text.toString())
                startActivity(intent)
            }
        }
    }
}