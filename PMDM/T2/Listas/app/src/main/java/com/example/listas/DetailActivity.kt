package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.listas.databinding.ActivityDetailBinding
import com.example.listas.model.Coche

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var coche: Coche

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coche = intent.extras!!.getSerializable("coche") as Coche


        Glide.with(applicationContext)
            .load(coche.imagen)
            .placeholder(R.drawable.defecto)
            .into(binding.imagenModelo)
        //binding.imagenModelo.setImageResource(coche.imagen)
        binding.nombreModelo.text =  coche.nombre


    }

}