package com.example.samarth_admin123

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samarth_admin123.databinding.ActivityEditProductBinding
import com.google.firebase.firestore.FirebaseFirestore

class EditProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProductBinding
    private lateinit var firestore: FirebaseFirestore
    private var productId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        productId = intent.getStringExtra("productId") ?: ""

        loadProduct()

        binding.btnUpdate.setOnClickListener {
            updateProduct()
        }
    }

    private fun loadProduct() {
        if (productId.isEmpty()) return

        firestore.collection("Products")
            .document(productId)
            .get()
            .addOnSuccessListener { doc ->
                binding.etName.setText(doc.getString("name"))
                binding.etPrice.setText(doc.get("price").toString())
                binding.etDescription.setText(doc.getString("description"))
            }
    }

    private fun updateProduct() {
        val name = binding.etName.text.toString()
        val price = binding.etPrice.text.toString().toDouble()
        val description = binding.etDescription.text.toString()

        val productMap = hashMapOf(
            "name" to name,
            "price" to price,
            "description" to description
        )

        firestore.collection("Products")
            .document(productId)
            .update(productMap as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "Product Updated", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Update Failed", Toast.LENGTH_SHORT).show()
            }
    }
}
