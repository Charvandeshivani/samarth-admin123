package com.example.samarth_admin123

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samarth_admin123.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle register button click
        binding.registerBtn.setOnClickListener {
            val username = binding.usernameEt.text.toString().trim()
            val email = binding.emailEt.text.toString().trim()
            val password = binding.passwordEt.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Pass signup data to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("email", email)
                intent.putExtra("password", password)
                startActivity(intent)
                Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
