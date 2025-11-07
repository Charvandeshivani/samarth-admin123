package com.example.samarth_admin123

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.samarth_admin123.databinding.ActivityCustomerDetailsBinding

class CustomerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")

        binding.txtDetailName.text = name
        binding.txtDetailPhone.text = phone
    }
}
