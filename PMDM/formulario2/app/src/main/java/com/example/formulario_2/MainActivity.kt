package com.example.formulario_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import com.example.formulario_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener, OnLongClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pulsacion a boton (2)
        binding.botonLogin.setOnClickListener(this)
        binding.botonLogin.setOnLongClickListener(this)
        binding.botonLimpiar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // ejecutar cuando un boton o elemento sea pulsado
        // que boton ha sido pulsado???
        when (v?.id) {
            binding.botonLogin.id -> {
                // intent - origen - destino
                val intent: Intent = Intent(this.applicationContext, SecondActivity::class.java)
                val bundle: Bundle = Bundle() // caja
                bundle.putString("correo", binding.editCorreo.text.toString())
                bundle.putSerializable(
                    "objeto",
                    Usuario(binding.editCorreo.text.toString(), binding.editPass.text.toString())
                )
                intent.putExtra("datos", bundle) // el intent va acompañado de datos
                startActivity(intent)
            }

            binding.botonLimpiar.id -> {
                limpiar()
            }
        }
    }

    fun limpiar() {
        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
    }

    override fun onRestart() {
        super.onRestart()
        limpiar()
    }

    override fun onLongClick(v: View?): Boolean {
        TODO("Not yet implemented")
    }
}

// MA onCreate - onStart - onResumen -XXXXX - onPause - onStop - onRestart - onStart - onResume - XXXXX
// SA onCreate - onStart - onResumen -XXXXX - onPause - onStop - onDestroy