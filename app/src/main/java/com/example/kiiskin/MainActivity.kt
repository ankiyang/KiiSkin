package com.example.kiiskin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // direct to acitivity_main.xml

        startButton.setOnClickListener {
            val message: String = UserMessage.text.toString()
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SignIn::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }
//        startButton.setOnClickListener {
//            // Code
//            Log.i("MainActivity", "Button was clicked")
//            Toast.makeText(this, "Button was clicked", Toast.LENGTH_SHORT).show()
//        }


    }
}
