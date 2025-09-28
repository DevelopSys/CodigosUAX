package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // onClickListener
        binding.botonLogin.setOnClickListener(this)
        binding.botonLimpiar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // quien lo ha pulsado
            // login->login
            // limpiar-> limpia
        when(v?.id){
            binding.botonLogin.id->{
                if (binding.editPass.text.isNotEmpty() && binding.editCorreo.text.isNotEmpty()){
                    // origen - destino
                    // applicationCtx o this
                    val intent: Intent = Intent(this, SecondActivity::class.java)
                    val bundle: Bundle = Bundle();
                    // bundle.putString("correo", binding.editCorreo.text.toString())
                    bundle.putSerializable("objeto", Usuario("","",""))
                    intent.putExtra("datos",bundle)
                    startActivity(intent)
                } else{
                    Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_SHORT).show()
                }
            }
            binding.botonLimpiar.id->{
                limpiar()
            }
        }
    }

    fun limpiar(){
        binding.editPass.text.clear()
        binding.editCorreo.text.clear()
    }

    override fun onRestart() {
        super.onRestart()
        limpiar()
    }
}

// primera pantalla -> onCreate - onStart - onResume - VIENDO - onPause - onStop - onDestroy
// segunda pantalla -> onCreate - onStart - onResume - VIENDO - onPause - onStop - onDestroy