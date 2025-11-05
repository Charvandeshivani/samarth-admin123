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

        // Get Data from Adapter
        val productName = intent.getStringExtra("name") ?: "No Name"
        val productPrice = intent.getStringExtra("price") ?: "0"
        val productDesc = intent.getStringExtra("desc") ?: "No Description"
        val productImg = intent.getStringExtra("imageUrl")

        binding.tvProductName.text = productName
        binding.tvProductPrice.text = "₹$productPrice"
        binding.tvProductDescription.text = productDesc

        // Load image using Glide
        if (!productImg.isNullOrEmpty()) {
            Glide.with(this)
                .load(productImg)
                .into(binding.ivProductImage)
        } else {
            binding.ivProductImage.setImageResource(R.drawable.ic_no_image)
        }
    }
}
