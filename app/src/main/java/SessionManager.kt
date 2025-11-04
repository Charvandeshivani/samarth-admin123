package com.example.samarth_admin123

import android.content.Context

class SessionManager(context: Context) {

    private val sharedPref = context.getSharedPreferences("AdminPref", Context.MODE_PRIVATE)

    fun saveAdmin(email: String, password: String) {
        sharedPref.edit()
            .putString("EMAIL", email)
            .putString("PASSWORD", password)
            .putBoolean("IS_REGISTERED", true)
            .apply()
    }

    fun getEmail(): String? = sharedPref.getString("EMAIL", "")
    fun getPassword(): String? = sharedPref.getString("PASSWORD", "")
    fun isAdminRegistered(): Boolean = sharedPref.getBoolean("IS_REGISTERED", false)

    fun logout() {
        sharedPref.edit().clear().apply()
    }
}
