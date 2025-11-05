package com.example.samarth_admin123

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)

        val cardOrders: CardView = findViewById(R.id.cardOrders)
        val cardProducts: CardView = findViewById(R.id.cardProducts)
        val cardCustomers: CardView = findViewById(R.id.cardCustomers)


        cardOrders.setOnClickListener {
            startActivity(Intent(this, OrdersActivity::class.java))
        }

        cardProducts.setOnClickListener {
            startActivity(Intent(this, ProductsActivity::class.java))
        }

        cardCustomers.setOnClickListener {
            startActivity(Intent(this, CustomersActivity::class.java))
        }


    }
}
