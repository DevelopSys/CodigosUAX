package com.example.listas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.listas.databinding.ActivityMainBinding
import com.example.listas.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener {
            // onclick
            if (binding.editUsuario.text.toString().equals("Admin",true)
                && binding.editPass.text.toString().equals("admin")){
                // voy a pasar de pantalla
                val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("usuario",Usuario(binding.editUsuario.toString(), binding.editPass.toString()))
                startActivity(intent)
            } else {
                // Snackbar
                Snackbar.make(binding.root,"Error en los datos",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}