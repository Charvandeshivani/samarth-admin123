package com.example.samarth_admin123

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samarth_admin123.databinding.CustomerDetailsBinding
import com.google.firebase.firestore.FirebaseFirestore

class CustomerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: CustomerDetailsBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CustomerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("email")

        if (email != null) {
            loadCustomerDetails(email)
        } else {
            Toast.makeText(this, "Customer not found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadCustomerDetails(email: String) {
        db.collection("customers").document(email)
            .get()
            .addOnSuccessListener { doc ->
                if (doc.exists()) {
                    binding.txtDetailName.text = doc.getString("name")
                    binding.txtDetailPhone.text = doc.getString("phone")
                }
            }
    }
}
