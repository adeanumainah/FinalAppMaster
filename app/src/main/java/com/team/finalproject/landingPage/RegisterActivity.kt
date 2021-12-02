package com.team.finalproject.landingPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.team.finalproject.MainActivity
import com.team.finalproject.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tv_to_signin.text = HtmlCompat.fromHtml("Already have an account? <b>Sign In</b>", HtmlCompat.FROM_HTML_MODE_LEGACY)

        tv_to_signin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_back_to_signin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btn_signup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}