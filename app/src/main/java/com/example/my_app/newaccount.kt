package com.example.my_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.io.IOException
import java.io.OutputStreamWriter
import kotlin.random.Random

class newaccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newaccount)
        val back = findViewById<ImageView>(R.id.imageView19)
        back.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val firstname= findViewById<EditText>(R.id.curvedEditText1)
        val lastname= findViewById<EditText>(R.id.curvedEditText2)
        val email= findViewById<EditText>(R.id.curvedEditText3)
        val address= findViewById<EditText>(R.id.curvedEditText4)
        val age= findViewById<EditText>(R.id.curvedEditText5)
        val license= findViewById<EditText>(R.id.curvedEditText6)
        val password= findViewById<EditText>(R.id.editTextPassword)


        val btn = findViewById<Button>(R.id.button9)
        var randomVal = Random.nextInt(2)

        btn.setOnClickListener{
            if (TextUtils.isEmpty(firstname.text.toString()) or (TextUtils.isEmpty(lastname.text.toString())) or (TextUtils.isEmpty(email.text.toString()))
                   or (TextUtils.isEmpty(password.text.toString())) or (TextUtils.isEmpty(address.text.toString())) or (TextUtils.isEmpty(age.text.toString())) or (TextUtils.isEmpty(license.text.toString()))) {
                Toast.makeText(this, "Please enter all the details.", Toast.LENGTH_SHORT).show()
                if (randomVal == 1){
                    Toast.makeText(this, "Please enter valid license number.", Toast.LENGTH_SHORT).show()
                    randomVal = Random.nextInt(2)
                }
            }
            else{
                Toast.makeText(this, "License number verified.", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Account created successfully.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,SignUp::class.java)
                startActivity(intent)
                val userData = listOf(firstname.text.toString(),lastname.text.toString(),email.text.toString(),password.text.toString(),
                    age.text.toString(),address.text.toString(),license.text.toString())
                ExcelHelper.writeToUserInfoExcel(this, userData)
            }
        }
    }
}