package com.example.justtipers

import MyFirebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.justtipers.ProfilActivity
import com.example.justtipers.R
import com.google.firebase.FirebaseApp

class RegistrationActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var profileImageView: ImageView

    private var profileImageUri: Uri? = null
    private val myFirebase = MyFirebase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        etName = findViewById(R.id.nameEditText)
        etUsername = findViewById(R.id.usernameEditText)
        etEmail = findViewById(R.id.emailEditText)
        etPassword = findViewById(R.id.passwordEditText)
        registerButton = findViewById(R.id.registerButton)
        profileImageView = findViewById(R.id.profileImageView)

        profileImageView.setOnClickListener {
            // Panggil intent untuk memilih gambar dari galeri
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            resultLauncher.launch(intent)
        }

        registerButton.setOnClickListener {
            val name = etName.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Lakukan validasi input
            if (name.isEmpty()) {
                etName.error = "Nama tidak boleh kosong"
                etName.requestFocus()
                return@setOnClickListener
            }

            if (username.isEmpty()) {
                etUsername.error = "Username tidak boleh kosong"
                etUsername.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Password tidak boleh kosong"
                etPassword.requestFocus()
                return@setOnClickListener
            }

            myFirebase.registerUser(name, username) { newUserId ->
                myFirebase.getUserData(newUserId) { name, username ->
                    val intent = Intent(this, ProfilActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    finish()
                }
            }
        }

        // Inisialisasi Firebase
        FirebaseApp.initializeApp(this)
    }

    // Panggil intent untuk memilih gambar dari galeri
    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK && result.data != null) {
            val selectedImageUri = result.data!!.data
            selectedImageUri?.let {
                profileImageView.setImageURI(it)
                profileImageUri = it
            }
        }
    }

    // Simpan state profileImageUri pada instance state activity
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("profileImageUri", profileImageUri)
    }

    // Restore state profileImageUri pada instance state activity
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        profileImageUri = savedInstanceState.getParcelable("profileImageUri")
        profileImageUri?.let {
            profileImageView.setImageURI(it)
        }
    }
}
