package com.example.samarth_admin123

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: MutableList<Product>,
    private val onEditClick: (Product) -> Unit,
    private val onDeleteClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val btnEdit: Button = view.findViewById(R.id.btnEdit)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.tvName.text = product.name
        holder.tvPrice.text = "₹${product.price}"
        holder.tvDescription.text = product.description

        // Open ProductDetailsActivity when item is clicked
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetailsActivity::class.java).apply {
                putExtra("name", product.name)
                putExtra("price", product.price)
                putExtra("description", product.description)
                putExtra("stock", product.stock)
                putExtra("imageUrl", product.imageUrl)
            }
            context.startActivity(intent)
        }

        // Edit button - Navigate to EditProductActivity
        holder.btnEdit.setOnClickListener {
            onEditClick(product)
        }

        // Delete button
        holder.btnDelete.setOnClickListener {
            onDeleteClick(product)
        }
    }

    override fun getItemCount(): Int = productList.size

    // ✅ Add this function to dynamically add a product
    fun addProduct(product: Product) {
        productList.add(product)
        notifyItemInserted(productList.size - 1)
    }

    // ✅ Optional helper function for refreshing all items (if needed)
    fun updateProducts(newList: List<Product>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
}
