package com.example.samarth_admin123

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samarth_admin123.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var registeredEmail = ""
    private var registeredPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve email and password from SignUpActivity (if any)
        registeredEmail = intent.getStringExtra("email") ?: ""
        registeredPassword = intent.getStringExtra("password") ?: ""

        // Handle Login button click
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEt.text.toString().trim()
            val password = binding.passwordEt.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else if (email == registeredEmail && password == registeredPassword) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
