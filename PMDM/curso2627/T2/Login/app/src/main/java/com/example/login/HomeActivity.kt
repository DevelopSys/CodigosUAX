package com.example.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding
    private var currentUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentUserName = intent.getStringExtra("user_name")
        binding.textUser.text = "Bienvenido ${currentUserName?:"Invitado"}"


    }
}