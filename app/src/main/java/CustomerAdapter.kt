package com.example.samarth_admin123

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samarth_admin123.databinding.ItemCustomerBinding

class CustomerAdapter(private val customers: List<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    inner class CustomerViewHolder(val binding: ItemCustomerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding = ItemCustomerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = customers[position]

        holder.binding.txtCustomerName.text = customer.name
        holder.binding.txtCustomerPhone.text = customer.phone

        holder.binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${customer.phone}")
            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CustomerDetailsActivity::class.java)
            intent.putExtra("name", customer.name)
            intent.putExtra("phone", customer.phone)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = customers.size
}
