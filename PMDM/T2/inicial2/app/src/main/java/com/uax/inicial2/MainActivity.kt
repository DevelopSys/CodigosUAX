package com.uax.inicial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.uax.inicial2.databinding.ActivityMainBinding


/*LOGICA DE UNA PANTALLA*/
/*COMO SE UTILIZA LAS COSAS GRAFICAS*/
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        /*Junto lo grafico y lo logico*/
        setContentView(binding.root)
        /*YA ESTA JUNTO LO GRAFICO Y LOGICO*/
        binding.botonPulsar.setOnClickListener {
            /*Saca una notificacion: Snackbar - Toast*/
            Snackbar.make(binding.root,
                "Enhorabuena, primera app android"
                , Snackbar.LENGTH_LONG).show()
        }
    }
}