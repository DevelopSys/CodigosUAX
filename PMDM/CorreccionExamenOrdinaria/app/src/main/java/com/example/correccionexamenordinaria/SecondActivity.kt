package com.example.correccionexamenordinaria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.correccionexamenordinaria.databinding.ActivityMainBinding
import com.example.correccionexamenordinaria.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nota: Double = intent.getDoubleExtra("media",0.0)
        binding.textoNota.text = "Tu media es de ${nota}"
    }
}