package com.example.samarth_admin123

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samarth_admin123.databinding.ActivityCustomersBinding

class CustomersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomersBinding
    private lateinit var adapter: CustomerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customerList = listOf(
            Customer("Amit Sharma", "9876543210"),
            Customer("Priya Singh", "9123456780"),
            Customer("Rahul Patil", "9998887776"),
            Customer("Sneha Desai", "9545545455")
        )

        adapter = CustomerAdapter(customerList)
        binding.recyclerCustomers.layoutManager = LinearLayoutManager(this)
        binding.recyclerCustomers.adapter = adapter
    }
}
