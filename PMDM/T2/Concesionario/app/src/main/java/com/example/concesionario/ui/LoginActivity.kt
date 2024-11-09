package com.example.concesionario.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.R
import com.example.concesionario.databinding.ActivityLoginBinding
import com.example.concesionario.model.Usuario
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var usuarios: ArrayList<Usuario>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        // initGUI()
        acciones()


    }

    private fun instancias() {
        usuarios = arrayListOf(
            Usuario(
                "Borja",
                "borja@gmail.com",
                "1234"
            ),
            Usuario("Juan", "juan@gmail.com", "2345"),
            Usuario("Maria", "maria@gmail.com", "3456"),
        )
    }

    private fun initGUI() {
        binding.grupoUsuario.check(binding.radioRegistrado.id)
    }

    private fun acciones() {

        binding.btnAcceso.setOnClickListener(this)
        binding.grupoUsuario.setOnCheckedChangeListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnAcceso.id -> {
                // cambiar de escena
                val radioSeleccionado: Int = binding.grupoUsuario.checkedRadioButtonId
                val intent: Intent = Intent(applicationContext,CarsActivity::class.java)
                when (radioSeleccionado) {

                    binding.radioInvitado.id -> {
                        // si soy invitado -> accedo directamente
                        // accedo directamente
                        startActivity(intent)
                    }

                    binding.radioRegistrado.id -> {
                        val usuario: Usuario? = usuarios.find {
                            it.correo.equals(binding.editCorreo.text.toString()) &&
                                    it.pass.equals(binding.editPass.text.toString()
                            )
                        }
                        if (usuario == null){
                            Snackbar.make(binding.root, "Error al iniciar", Snackbar.LENGTH_SHORT).show()
                        } else {
                            startActivity(intent)
                        }
                    }
                }

            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when (p0?.id) {
            binding.grupoUsuario.id -> {
                when (p1) {
                    binding.radioInvitado.id -> {
                        binding.editPass.isEnabled = false
                        binding.editCorreo.isEnabled = false
                    }

                    binding.radioRegistrado.id -> {
                        binding.editPass.isEnabled = true
                        binding.editCorreo.isEnabled = true
                    }
                }
            }
        }
    }
}