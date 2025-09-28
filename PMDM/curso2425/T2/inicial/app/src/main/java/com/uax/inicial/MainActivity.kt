package com.uax.inicial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.google.android.material.snackbar.Snackbar
import com.uax.inicial.databinding.ActivityMainBinding
import com.uax.inicial.model.Usuario

// LOGICA DE UNA PANTALLA -> ACTIVITY
class MainActivity : AppCompatActivity(), OnClickListener {
    // primer metodo del ciclo de vida
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // asocia parte grafica y parte logica (this)
        setContentView(binding.root)
        asociarDatos()
        // acciones()
    }

    private fun asociarDatos() {

    }

    private fun acciones() {
        binding.botonPulsar.setOnClickListener(this)
        binding.botonSaludo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // ejecutado cuando un boton es pulsado -> funcionalidad
        // diferenciar si uno u otro es el pulsado

        when (v!!.id) {
            binding.botonPulsar.id -> {
                Snackbar.make(
                    binding.root,
                    "Enhorabuena priemara APP android",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            binding.botonSaludo.id -> {
                if (binding.editNombre.text.isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        "No hay nombre, por favor comprueba la funcionalidad ${binding.editNombre.text.toString()}",
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    val usuario: Usuario = Usuario(binding.editNombre.text.toString())
                    Snackbar.make(
                        binding.root,
                        "Muy buen trabajo ${usuario.nombre}",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}