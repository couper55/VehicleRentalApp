package com.example.my_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
//import com.example.my_app.ExcelHelper

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn1=findViewById<Button>(R.id.button)
        btn1.setBackgroundColor(Color.parseColor("#4B1CB8"))
        btn1.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.editTextEmail)// Get the entered email from the view (EditText, etc.)
            val passwordEditText = findViewById<EditText>(R.id.editTextPassword)// Get the entered password from the view (EditText, etc.)
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (checkCredentials(email, password)) {
                val intent = Intent(this, FirstLook::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        val back = findViewById<ImageView>(R.id.imageView2)
        back.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val createacc = findViewById<TextView>(R.id.textView7)
        createacc.setOnClickListener{
            val intent = Intent(this,newaccount::class.java)
            startActivity(intent)
        }
    }
     fun checkCredentials(email: String, password: String): Boolean {
        val userInfo = ExcelHelper.readUserInfoFromExcel(this)

        // Loop through the userInfo to check if the email and password match
        for (userData in userInfo) {
            val userDataArray = userData.split(",")
            val userEmail = userDataArray[2]
            val userPassword = userDataArray[3]

            if (email == userEmail && password == userPassword) {
                return true
            }
        }
        return false
    }
}
