package com.example.formulario_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var datosRecuperados: Bundle? = null
    private var usuario: Usuario? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        datosRecuperados = intent.extras?.getBundle("datos")
        usuario = datosRecuperados?.getSerializable("objeto") as Usuario
        binding.textoCorreo.text = usuario?.correo ?: "sin correo"
    }
}