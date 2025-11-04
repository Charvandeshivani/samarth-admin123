package com.example.samarth_admin123

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class OrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val cardCheckStatus: CardView = findViewById(R.id.cardCheckStatus)
        val cardNewOrders: CardView = findViewById(R.id.cardNewOrders)

        cardCheckStatus.setOnClickListener {
            startActivity(Intent(this, OrderStatusActivity::class.java))
        }

        cardNewOrders.setOnClickListener {
            startActivity(Intent(this, PendingOrdersActivity::class.java))
        }
    }
}
