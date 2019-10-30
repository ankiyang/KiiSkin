package com.example.kiiskin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.activity_signup.*

class MainActivity : AppCompatActivity() {
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // direct to acitivity_main.xml

        handler = DatabaseHelper(this)
        showHome()

        MainRegButton.setOnClickListener {
            System.out.println("MainRegButton onclick")
            showRegistration()
        }
        MainSignInButton.setOnClickListener {
            System.out.println("Main Sign In onclick")
            showLogIn()
        }

        AccountSave.setOnClickListener {
            handler.insertUserData(
                username.text.toString(),
                email.text.toString(),
                password.text.toString()
            )
//            showHome()
            System.out.println("account save  onclick")
            Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.setClass(this, StartActivity::class.java)
            intent.putExtra("user_name", username.text.toString());
            startActivity(intent)
        }

        login_btn.setOnClickListener {
            if (handler.userPresent(SignInEmailInput.text.toString(), SignInPasswordInput.text.toString()))
                loginsuccess()
            else
                Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_SHORT).show()
        }

        gotosignup.setOnClickListener {
            System.out.println("return to registration page")
            showRegistration()
        }
    }

    private fun loginsuccess(){
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        System.out.println("account save  onclick")
        val intent = Intent()
        //获取intent对象
        intent.setClass(this, StartActivity::class.java)
        intent.putExtra("user_name", username.text.toString());
        // 获取class是使用::反射
        startActivity(intent)
    }
    private fun showRegistration() {
        System.out.println("showRegistration")
        main_registration.visibility = View.VISIBLE
        main_signin.visibility = View.GONE
        home_11.visibility= View.GONE
    }
    private fun showLogIn(){
        main_registration.visibility = View.GONE
        main_signin.visibility = View.VISIBLE
        home_11.visibility= View.GONE
    }
    private fun showHome(){
        main_registration.visibility = View.GONE
        main_signin.visibility = View.GONE
        home_11.visibility= View.VISIBLE

    }
}
