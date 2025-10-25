package com.example.samarth_admin123 // Ensure this is the correct package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Connect this Kotlin file to the home screen layout
        setContentView(R.layout.activity_home)
    }
}
    