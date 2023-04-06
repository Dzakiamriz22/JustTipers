package com.example.justtipers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class NewPostActivity : AppCompatActivity() {
    private lateinit var addImage: ImageView
    private lateinit var postButton: Button
    private lateinit var imageView1: ImageView
    private lateinit var imageView3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        addImage = findViewById(R.id.add_image)
        postButton = findViewById(R.id.post_button)
        imageView1 = findViewById(R.id.imageView1)
        imageView3 = findViewById(R.id.imageView3)

        addImage.setOnClickListener {
            // Minta input gambar dari user
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 0)
        }

        postButton.setOnClickListener {
            // Masuk ke ContentActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        imageView1.setOnClickListener {
            // Masuk ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        imageView3.setOnClickListener {
            // Masuk ke ProfilActivity
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0 && resultCode == RESULT_OK && data != null) {
            // Set gambar pada ImageView
            val selectedImage = data.data
            addImage.setImageURI(selectedImage)
        }
    }
}

