package com.example.samarth_admin123

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samarth_admin123.databinding.ActivityCustomersBinding

class CustomersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomersBinding
    private lateinit var adapter: CustomerAdapter
    private val customerList = ArrayList<Customer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        showDemoData() // ✅ Visible now
    }

    private fun setupRecycler() {
        adapter = CustomerAdapter(customerList)
        binding.recyclerCustomers.layoutManager = LinearLayoutManager(this)
        binding.recyclerCustomers.adapter = adapter
    }

    private fun showDemoData() {
        // ✅ Dummy data until Firebase connected
        customerList.add(Customer("mame ", "9876543210"))
        customerList.add(Customer("name ", "9123456789"))
        customerList.add(Customer("name ", "9000000000"))

        adapter.notifyDataSetChanged()

        // ✅ Hide or show "No data" message
        if (customerList.isEmpty()) {
            binding.tvNoData.visibility = View.VISIBLE
        } else {
            binding.tvNoData.visibility = View.GONE
        }
    }
}
