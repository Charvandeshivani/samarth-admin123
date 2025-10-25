package com.example.samarth_admin123 // This must match your app's package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// V-- THIS IS THE FIX for the "R error" --V
// This line tells your code where to find the R class.
// Make sure "com.example.samarth_admin123" is your correct package name.
import com.example.samarth_admin123.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This line will now work because the R class is imported correctly
        setContentView(R.layout.activity_main)
    }
}
