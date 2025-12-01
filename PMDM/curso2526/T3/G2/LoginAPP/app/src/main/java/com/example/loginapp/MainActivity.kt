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
import com.google.firebase.auth.auth

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
        auth = com.google.firebase.Firebase.auth
    }

    private fun acciones() {
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
                        intent.putExtra("correo",correo)
                        intent.putExtra("pass",pass)
                        intent.putExtra("uid",auth.currentUser!!.uid)
                        startActivity(intent)
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Los datos son incorrectos",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        binding.botonGoogle.setOnClickListener {
            // analiza cada uno de los datos de la interfaz -> procesar los datos
            val correo = binding.editMail.text.toString()
            val pass = binding.editPass.text.toString()

            if (correo.isEmpty() || pass.isEmpty()) {
                Snackbar.make(
                    it, "Datos vacios, por favor rellena todo",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            } else {
                auth.createUserWithEmailAndPassword(correo, pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Snackbar.make(
                                binding.root,
                                "Cuenta creada correctamente",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        } else {
                            Snackbar.make(
                                binding.root,
                                "Error en el proceso",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
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