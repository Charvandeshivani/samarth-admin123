package com.example.samarth_admin123

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var signInBtn: Button
    private lateinit var loginLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        signInBtn = findViewById(R.id.signInBtn)
        loginLink = findViewById(R.id.loginLink)

        signInBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        loginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}