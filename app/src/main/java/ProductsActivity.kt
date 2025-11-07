package com.example.samarth_admin123

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samarth_admin123.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private val productList = mutableListOf<Product>()
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Setup RecyclerView
        adapter = ProductAdapter(
            productList,
            onEditClick = { product -> editProduct(product) },
            onDeleteClick = { product -> deleteProduct(product) }
        )
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProducts.adapter = adapter

        // ✅ Add sample demo products once
        if (productList.isEmpty()) {
            productList.addAll(
                listOf(
                    Product("Power Drill", 2499.0),
                    Product("Angle Grinder", 2199.0),
                    Product("Electric Saw", 4999.0),
                    Product("Impact Wrench", 5499.0)
                )
            )
            adapter.notifyDataSetChanged()
        }

        // ✅ Add Product button
        binding.btnAddProduct.setOnClickListener {
            showAddProductDialog()
        }
    }

    // ✅ Show dialog to add a new product
    private fun showAddProductDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_product, null)
        val nameInput = dialogView.findViewById<android.widget.EditText>(R.id.etProductName)
        val priceInput = dialogView.findViewById<android.widget.EditText>(R.id.etProductPrice)

        AlertDialog.Builder(this)
            .setTitle("Add New Product")
            .setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val name = nameInput.text.toString().trim()
                val price = priceInput.text.toString().toDoubleOrNull() ?: 0.0

                if (name.isNotEmpty()) {
                    val newProduct = Product(name, price)

                    // ✅ Add at bottom, keep old items, scroll to new one
                    productList.add(newProduct)
                    adapter.notifyItemInserted(productList.size - 1)
                    binding.recyclerViewProducts.scrollToPosition(productList.size - 1)
                }

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    // ✅ Edit Product (placeholder)
    private fun editProduct(product: Product) {
        android.widget.Toast.makeText(this, "Edit: ${product.name}", android.widget.Toast.LENGTH_SHORT).show()
    }

    // ✅ Delete Product
    private fun deleteProduct(product: Product) {
        val index = productList.indexOf(product)
        if (index != -1) {
            productList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }
    }
}
