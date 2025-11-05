package com.example.samarth_admin123

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samarth_admin123.databinding.ActivityOrderStatusBinding

class OrderStatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderStatusBinding
    private val orderList = ArrayList<Order>()
    private lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = OrderAdapter(orderList)
        binding.recyclerOrderStatus.layoutManager = LinearLayoutManager(this)
        binding.recyclerOrderStatus.adapter = adapter

        showPlaceholder()
    }

    private fun showPlaceholder() {
        binding.tvNoStatus.visibility = View.VISIBLE
        binding.recyclerOrderStatus.visibility = View.GONE
    }
}
