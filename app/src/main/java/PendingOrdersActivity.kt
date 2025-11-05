package com.example.samarth_admin123

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samarth_admin123.databinding.ActivityPendingOrdersBinding

class PendingOrdersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPendingOrdersBinding
    private val orderList = ArrayList<Order>()
    private lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = OrderAdapter(orderList)
        binding.recyclerPendingOrders.layoutManager = LinearLayoutManager(this)
        binding.recyclerPendingOrders.adapter = adapter

        showPlaceholder()
    }

    private fun showPlaceholder() {
        binding.tvNoPending.visibility = View.VISIBLE
        binding.recyclerPendingOrders.visibility = View.GONE
    }
}
