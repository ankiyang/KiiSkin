package com.example.kiiskin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin.*


class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val bundle = intent.extras
        val requestName = bundle!!.getString("user_message")
        HelloUser.text = "Hello, $requestName"
    }
}