package com.example.justtipers

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ProfilActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val logoutButton: ImageView = findViewById(R.id.ButtonLogout)
        val beATipersButton: Button = findViewById(R.id.BeATipersButton)
        val homeButton : ImageView = findViewById(R.id.imageView1)

        logoutButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

        beATipersButton.setOnClickListener {
            val intent = Intent(this, TipersActivity::class.java)
            startActivity(intent)
        }

        homeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
