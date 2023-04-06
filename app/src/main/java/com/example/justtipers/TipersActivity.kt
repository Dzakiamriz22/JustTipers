package com.example.justtipers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class TipersActivity : AppCompatActivity() {

    private val REQUEST_CODE = 100
    private lateinit var imageView3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipers)

        imageView3 = findViewById(R.id.imageView3)
        imageView3.setOnClickListener{
            // membuka aplikasi gallery
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)
        }

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            // membuka HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            imageView3.setImageURI(data?.data)
        }
    }
}
