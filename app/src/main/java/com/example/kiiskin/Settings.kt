package com.example.kiiskin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_setting.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_setting)

        ButtonShareToOtherApps.setOnClickListener{
//            val message: String

//            val intent = Intent()
//            intent.action = Intent.ACTION_SEND
//            intent.putExtra(Intent.EXTRA_TEXT, message)
//            intent.type = "text/plain"
//
//            startActivity(Intent.createChooser(intent, "Please Select App:"))

        }
    }
}