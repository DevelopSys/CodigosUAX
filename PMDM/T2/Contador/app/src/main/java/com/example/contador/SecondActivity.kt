package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contador.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding
    private var contador: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador = intent.extras?.getInt("contador") ?: -1
        binding.textoContador.text = contador.toString()
    }
}