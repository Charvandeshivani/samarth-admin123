package com.example.samarth_admin123

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.samarth_admin123.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receive data from intent
        val name = intent.getStringExtra("name")
        val price = intent.getDoubleExtra("price", 0.0)
        val description = intent.getStringExtra("description")
        val stock = intent.getIntExtra("stock", 0)
        val imageUrl = intent.getStringExtra("imageUrl")

        // Set data to UI
        binding.tvName.text = name
        binding.tvPrice.text = "₹$price"
        binding.tvStock.text = "Stock Available: $stock"
        binding.tvDescription.text = description

        // Show image (optional)
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(this).load(imageUrl).into(binding.ivProduct)
        } else {
            binding.ivProduct.setImageResource(R.drawable.ic_customers)
        }

        // Edit button click (future feature)
        binding.btnEdit.setOnClickListener {
            // Open edit screen or dialog later
        }
    }
}
