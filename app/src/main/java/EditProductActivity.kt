package com.example.samarth_admin123

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class EditProductActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var etProductName: EditText
    private lateinit var etProductPrice: EditText
    private lateinit var etProductDescription: EditText
    private lateinit var etProductStock: EditText
    private lateinit var btnUpdate: Button
    private lateinit var btnCancel: Button

    private var originalProductName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)

        db = FirebaseFirestore.getInstance()

        // Initialize views
        etProductName = findViewById(R.id.etProductName)
        etProductPrice = findViewById(R.id.etProductPrice)
        etProductDescription = findViewById(R.id.etProductDescription)
        etProductStock = findViewById(R.id.etProductStock)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnCancel = findViewById(R.id.btnCancel)

        // Get product details from intent
        originalProductName = intent.getStringExtra("PRODUCT_NAME") ?: ""
        val productPrice = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION") ?: ""
        val productStock = intent.getIntExtra("PRODUCT_STOCK", 0)

        // Set current values
        etProductName.setText(originalProductName)
        etProductPrice.setText(productPrice.toString())
        etProductDescription.setText(productDescription)
        etProductStock.setText(productStock.toString())

        // Update button click
        btnUpdate.setOnClickListener {
            updateProduct()
        }

        // Cancel button click
        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun updateProduct() {
        val name = etProductName.text.toString().trim()
        val priceText = etProductPrice.text.toString().trim()
        val description = etProductDescription.text.toString().trim()
        val stockText = etProductStock.text.toString().trim()

        if (name.isEmpty() || priceText.isEmpty() || description.isEmpty() || stockText.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val price = priceText.toDoubleOrNull()
        val stock = stockText.toIntOrNull()

        if (price == null || stock == null) {
            Toast.makeText(this, "Invalid price or stock value", Toast.LENGTH_SHORT).show()
            return
        }

        // Update in Firestore (using name as document ID)
        val productData = hashMapOf(
            "name" to name,
            "price" to price,
            "description" to description,
            "stock" to stock
        )

        db.collection("products").document(originalProductName)
            .update(productData as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "Product updated successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}