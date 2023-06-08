package com.example.justtipers

import MyFirebase
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.justtipers.HomeActivity
import com.example.justtipers.R
import com.example.justtipers.RegistrationActivity
import com.example.justtipers.TipersActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfilActivity : AppCompatActivity() {

    private val myFirebase = MyFirebase()
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val nameTextView: TextView = findViewById(R.id.NameTextView)
        val usernameTextView: TextView = findViewById(R.id.UsernameTextView)
        val logoutButton: ImageView = findViewById(R.id.ButtonLogout)
        val beATipersButton: Button = findViewById(R.id.BeATipersButton)
        val homeButton: ImageView = findViewById(R.id.imageView1)

        val name = intent.getStringExtra("name") ?: ""
        val username = intent.getStringExtra("username") ?: ""

        nameTextView.text = name
        usernameTextView.text = username

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
