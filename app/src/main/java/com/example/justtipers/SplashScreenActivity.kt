package com.example.justtipers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Log.d("SplashScreenActivity", "Splash screen is displayed") // log message
        Handler().postDelayed({
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}

