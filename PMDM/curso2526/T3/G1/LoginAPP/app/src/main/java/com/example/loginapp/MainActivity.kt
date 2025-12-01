package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import androidx.appcompat.app.AppCompatActivity

import com.example.loginapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones();
    }

    private fun instancias() {
        auth = FirebaseAuth.getInstance();
    }

    private fun acciones() {
        binding.botonGoogle.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editMail.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Snackbar.make(
                        binding.root,
                        "Usuario creado correctamente",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(
                        binding.root,
                        "Fallo en la creacion",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
        binding.botonLogin.setOnClickListener {
            // analiza cada uno de los datos de la interfaz -> procesar los datos
            val correo = binding.editMail.text.toString()
            val pass = binding.editPass.text.toString()
            val recordar = binding.checkRecordar.isChecked
            val plataforma = binding.spinnerPlataforma.selectedItem.toString()

            if (correo.isEmpty() || pass.isEmpty()) {
                Snackbar.make(
                    it, "Datos vacios, por favor rellena todo",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            } else {

                auth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra("uid",auth.currentUser!!.uid.toString())
                        intent.putExtra("correo",correo)
                        intent.putExtra("pass",pass)
                        startActivity(intent)
                    } else {
                        Snackbar.make(binding.root, "Fallo de credenciales", Snackbar.LENGTH_SHORT)
                            .show()

                    }
                }

                if (pass.equals("asd", true)) {
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("correo", binding.editMail.text.toString())

                    startActivity(intent)
                }
            }
        }
        binding.spinnerPlataforma.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                binding.botonGit.visibility = INVISIBLE
                binding.botonGoogle.visibility = INVISIBLE
                binding.botonFacebook.visibility = INVISIBLE
                when (position) {
                    0 -> {
                        binding.botonGoogle.visibility = VISIBLE
                    }

                    1 -> {
                        binding.botonFacebook.visibility = VISIBLE
                    }

                    2 -> {
                        binding.botonGit.visibility = VISIBLE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }
}