package com.github.pgycode.account

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)

        startActivity(Intent(this, Login1Activity::class.java))
        finish()
    }
}