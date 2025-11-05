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

        // Set up RecyclerView
        adapter = ProductAdapter(productList, { product -> editProduct(product) }, { product -> deleteProduct(product) })
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProducts.adapter = adapter

        // Add some sample products (so the screen shows data)
        productList.add(Product("Power Drill", 2499.0))
        productList.add(Product("Angle Grinder", 2199.0))
        productList.add(Product("Electric Saw", 4999.0))
        productList.add(Product("Impact Wrench", 5499.0))
        adapter.notifyDataSetChanged()

        // Add product button click
        binding.btnAddProduct.setOnClickListener {
            showAddProductDialog()
        }
    }

    private fun showAddProductDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_product, null)
        val nameInput = dialogView.findViewById<android.widget.EditText>(R.id.etProductName)
        val priceInput = dialogView.findViewById<android.widget.EditText>(R.id.etProductPrice)

        AlertDialog.Builder(this)
            .setTitle("Add New Product")
            .setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val name = nameInput.text.toString()
                val price = priceInput.text.toString().toDoubleOrNull() ?: 0.0
                if (name.isNotEmpty()) {
                    productList.add(Product(name, price))
                    adapter.notifyDataSetChanged()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun editProduct(product: Product) {
        // For now, just show a toast
        android.widget.Toast.makeText(this, "Edit: ${product.name}", android.widget.Toast.LENGTH_SHORT).show()
    }

    private fun deleteProduct(product: Product) {
        productList.remove(product)
        adapter.notifyDataSetChanged()
    }
}
