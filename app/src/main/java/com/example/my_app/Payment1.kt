package com.example.my_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Payment1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment1)
        val btn8 = findViewById<Button>(R.id.button8)
        val holdername = findViewById<EditText>(R.id.editText)
        val cardnum = findViewById<EditText>(R.id.editTextNumberPassword)
        val expirydate = findViewById<EditText>(R.id.editTextDate)
        val cvv = findViewById<EditText>(R.id.editTextNumberPassword2)
        val tnc = findViewById<CheckBox>(R.id.checkBox)
        val txtView31 = findViewById<TextView>(R.id.textView31)

        btn8.setOnClickListener{
            if (TextUtils.isEmpty(holdername.text.toString()) or TextUtils.isEmpty(cardnum.text.toString()) or TextUtils.isEmpty(expirydate.text.toString())
                or TextUtils.isEmpty(cvv.text.toString())){
                Toast.makeText(this, "Please enter all the details.", Toast.LENGTH_SHORT).show()
                if (!tnc.isChecked){
                    Toast.makeText(this, "Check terms and conditions.", Toast.LENGTH_SHORT).show()
                }
            }
            else{

                val intent = Intent(this,SuccessPayment1::class.java)
                startActivity(intent)
            }
        }
        txtView31.setOnClickListener{
            val intent = Intent(this,YourBooking1::class.java)
            startActivity(intent)
        }
    }
}