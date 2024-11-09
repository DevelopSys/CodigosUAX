package com.example.concesionario.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.R
import com.example.concesionario.databinding.ActivityDetailBinding
import com.example.concesionario.model.Modelo

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var modelo: Modelo;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("datos")
        modelo = bundle!!.getSerializable("coche")!! as Modelo
        binding.textoDetalle.text =
            "Marca: ${modelo.marca}\nModelo: ${modelo.modelo}\nPrecio: ${modelo.precio.toString()}"
        binding.imagenDetalle.setImageResource(modelo.imagen)
    }
}