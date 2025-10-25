package com.example.samarth_admin123 // This is your app's unique package name

// Other imports
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//
// V-- THIS IS THE LINE YOU NEED TO ADD --V
// It must match your package name exactly.
//
import com.example.samarth_admin123.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This line will now work because the R class can be found
        setContentView(R.layout.activity_main)
    }
}
