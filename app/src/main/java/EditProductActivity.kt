package com.example.samarth_admin123

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samarth_admin123.databinding.ActivityEditProductBinding
import com.google.firebase.firestore.FirebaseFirestore

class EditProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProductBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data from intent
        val productId = intent.getStringExtra("productId") ?: ""
        val name = intent.getStringExtra("name") ?: ""
        val price = intent.getDoubleExtra("price", 0.0)
        val description = intent.getStringExtra("description") ?: ""
        val stock = intent.getIntExtra("stock", 0)

        // Set values to input fields
        binding.editName.setText(name)
        binding.editPrice.setText(price.toString())
        binding.editDescription.setText(description)
        binding.editStock.setText(stock.toString())

        // Save updated data to Firestore
        binding.btnSaveChanges.setOnClickListener {
            val updatedName = binding.editName.text.toString()
            val updatedPrice = binding.editPrice.text.toString().toDoubleOrNull() ?: 0.0
            val updatedDescription = binding.editDescription.text.toString()
            val updatedStock = binding.editStock.text.toString().toIntOrNull() ?: 0

            if (productId.isNotEmpty()) {
                val updatedData = hashMapOf(
                    "name" to updatedName,
                    "price" to updatedPrice,
                    "description" to updatedDescription,
                    "stock" to updatedStock
                )

                db.collection("products").document(productId)
                    .update(updatedData as Map<String, Any>)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Product updated successfully!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Update failed: ${it.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Invalid product ID!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
