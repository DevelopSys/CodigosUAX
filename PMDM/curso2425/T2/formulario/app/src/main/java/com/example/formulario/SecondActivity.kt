package com.example.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var correoRecuperado: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundleRecuperado: Bundle? = intent.extras?.getBundle("datos")
        correoRecuperado = bundleRecuperado?.getString("correo") ?: "sin correo"
        binding.correo.text = correoRecuperado
    }
}