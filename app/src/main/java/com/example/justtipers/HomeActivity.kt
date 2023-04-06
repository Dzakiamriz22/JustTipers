package com.example.justtipers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageView1: ImageView = findViewById(R.id.imageView1)
        val imageView3: ImageView = findViewById(R.id.imageView3)
        val newPostButton: ImageView = findViewById(R.id.NewPostButton)

        imageView1.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        imageView3.setOnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }

        newPostButton.setOnClickListener {
            val intent = Intent(this, NewPostActivity::class.java)
            startActivity(intent)
        }
    }
}
