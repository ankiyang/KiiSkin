package com.example.kiiskin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*



class StartActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        StartSkip.setOnClickListener {
            System.out.println("Skip Click run...")

//            val intent = Intent()
//            intent.setClass(this, RecycleActivity::class.java)
//            startActivity(intent)
        }
    }


}