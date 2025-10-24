package com.example.inicial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.inicial.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        // binding.botonLanzar.setOnClickListener { Log.v("test","Boton pulsado lanzar") }
        // binding.botonLimpiar.setOnClickListener { Log.v("test","Boton pulsado limpiar") }
        // un parametro de tipo onclicklistener
        binding.botonLanzar.setOnClickListener(this)
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonNueva?.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        Log.v("test", "Boton pulsado")
        // diferenciar que boton se ha pulsado
        when (v?.id) {
            binding.botonLimpiar.id -> {
                binding.editNombre.text.clear()
            }

            binding.botonLanzar.id -> {
                var texto: String = binding.editNombre.text.toString()
                if (texto.isEmpty()){
                    Snackbar.make(
                        v, "Por favor introduce datos",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    binding.editNombre.text.clear()
                    Snackbar.make(
                        v, "Enhorabuena $texto has completado tu primera android app",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }

            binding.botonNueva?.id ->{
                // Snackbar.make(v!!,"Lanzando nueva pantalla", Snackbar.LENGTH_SHORT).show()
                // origen de la cominicacion -> el destino de la comunicacion (class)
                val intent = Intent(applicationContext, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }


}