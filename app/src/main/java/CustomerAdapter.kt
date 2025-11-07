package com.example.samarth_admin123

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter(private val list: List<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_customer, parent, false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = list[position]
        holder.name.text = customer.name
        holder.phone.text = "Phone: ${customer.phone}"
    }

    override fun getItemCount(): Int = list.size

    class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.txtCustomerName)
        val phone: TextView = itemView.findViewById(R.id.txtCustomerPhone)
    }
}
