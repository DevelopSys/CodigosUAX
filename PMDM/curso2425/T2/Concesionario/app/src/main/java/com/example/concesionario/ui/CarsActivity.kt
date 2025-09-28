package com.example.concesionario.ui

import android.graphics.ColorSpace.Model
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.example.concesionario.R
import com.example.concesionario.adapters.AdaptadorMarcas
import com.example.concesionario.adapters.AdaptadorModelos
import com.example.concesionario.databinding.ActivityCarsBinding
import com.example.concesionario.databinding.ActivityLoginBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Modelo
import com.google.android.material.snackbar.Snackbar

class CarsActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityCarsBinding

    // lista
    private lateinit var listaMarcas: ArrayList<Marca>

    // adaptador
    private lateinit var adaptadorMarcas: AdaptadorMarcas

    // lista
    private lateinit var listaModelos: ArrayList<Modelo>

    // adaptador
    private lateinit var adaptadorModelos: AdaptadorModelos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        // binding.spinnerMarcas.adapter =
        acciones()
    }

    private fun acciones() {
        binding.spinnerMarcas.onItemSelectedListener = this
    }

    private fun instancias() {

        listaMarcas =
            arrayListOf(
                Marca("Mercedes", R.drawable.mercedes),
                Marca("BMW", R.drawable.bmw),
                Marca("Ford", R.drawable.ford),
                Marca("BYD", R.drawable.byd),
                Marca("Audi", R.drawable.audi),
                Marca("Peugeot", R.drawable.peugeot)
            )
        adaptadorMarcas = AdaptadorMarcas(listaMarcas, applicationContext)
        binding.spinnerMarcas.adapter = adaptadorMarcas


        listaModelos = arrayListOf(
            Modelo(
                "C 63 S E PERFORMANCE",
                "Mercedes",
                140000,
                400,
                "Deportivo de mercedes",
                R.drawable.c63
            ), Modelo(
                "C E3 S E PERFORMANCE",
                "Mercedes",
                240000,
                500,
                "Deportivo de mercedes",
                R.drawable.e63
            ),
            Modelo(
                "RS 7 Sportback",
                "Audi",
                140000,
                400,
                "Deportivo de audi",
                R.drawable.rs7
            ),
            Modelo(
                "RS 8 Sportback",
                "Audi",
                140000,
                400,
                "Deportivo de audi",
                R.drawable.rsq8
            ),
            Modelo(
                "RS 5 Sportback",
                "Audi",
                140000,
                400,
                "Deportivo de audi",
                R.drawable.rs5
            ),
            Modelo(
                "Ford Mustang GT",
                "Ford",
                140000,
                400,
                "Deportivo de ford",
                R.drawable.mustangt
            ),
            Modelo(
                "Ford Mustang GT Match",
                "Ford",
                140000,
                400,
                "Deportivo de ford",
                R.drawable.mustangmatch
            ),
            Modelo(
                "BYD Seal",
                "BYD",
                40000,
                200,
                "Deportivo de BYD",
                R.drawable.seal
            )

        )
        adaptadorModelos = AdaptadorModelos(listaModelos, this)
        binding.recyclerModelos.adapter = adaptadorModelos;
        if (resources.configuration.orientation == 1) {
            binding.recyclerModelos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else if (resources.configuration.orientation == 2) {
            binding.recyclerModelos.layoutManager =
                GridLayoutManager(this, 2)
        }


    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val marcaSeleccionada: Marca = adaptadorMarcas.getItem(p2)
        /*Snackbar.make(
            binding.root,
            "La marca seleccionada es ${marcaSeleccionada.nombre}",
            Snackbar.LENGTH_SHORT
        ).show()*/
        // Vas a la lista y te quedas solo con los modelos que tienen como atributo marca la misma
        // que el spinner tiene seleccionada
        val listaFiltrada: ArrayList<Modelo> = listaModelos.filter {
            it.marca.equals(marcaSeleccionada.nombre, true)
        } as ArrayList<Modelo>
        adaptadorModelos.actualizarLista(listaFiltrada)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}