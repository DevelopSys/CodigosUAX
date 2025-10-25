package com.example.inicial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicial.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // el primer metodo ejecutado en el ciclo de vida
    // se encarga de asociar la parte grafica y la logica
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonSaludar.setOnClickListener(this::onClick)
        binding.botonEmpezar.setOnClickListener(this::onClick)
        binding.botonLimpiar?.setOnClickListener(this::onClick)
    }

    override fun onClick(v: View?) {
        // lo comun a los n botones
        when(v!!.id){

            binding.botonLimpiar?.id ->{
                binding.editNombre.text.clear()
            }
            binding.botonSaludar.id->{

                val nombre= binding.editNombre.text.toString()
                if (nombre.isEmpty()){
                    Snackbar.make(v,"Por favor introduce datos"
                        , Snackbar.LENGTH_LONG).show()
                } else {
                    Snackbar.make(v,"Enhorabuena $nombre has superado la primera app"
                        , Snackbar.LENGTH_LONG).show()
                    binding.editNombre.text.clear()
                }

            }
            binding.botonEmpezar.id->{

                val intent: Intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }

}