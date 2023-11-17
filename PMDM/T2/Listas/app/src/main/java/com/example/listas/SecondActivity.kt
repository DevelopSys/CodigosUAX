package com.example.listas

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.listas.data.DataSet
import com.example.listas.databinding.ActivitySecondBinding
import com.example.listas.model.Coche
import com.example.listas.model.Usuario
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    // parte de datos de mi lista
    private lateinit var adaptadorLista: ArrayAdapter<Coche>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // nombreUsuario = null
        // ctx, layout, lista
        adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,DataSet.getAllModelos());
        binding.listViewModelos.adapter = adaptadorLista;
        binding.nombreUsuario.text = (intent.extras?.getSerializable("usuario")
                as Usuario).nombre
        binding.spinnerMarcas.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val marcaSeleccionada = parent!!.adapter.getItem(position).toString()
                val listaFiltrada = DataSet.getAllModelos().filter { it.marca.equals(marcaSeleccionada, true) }
                adaptadorLista.clear()
                adaptadorLista.addAll(listaFiltrada)
            /*Snackbar.make(binding.root, binding.spinnerMarcas.selectedItem.toString(), Snackbar.LENGTH_SHORT)
                    .show()*/
                // parent?.adapter?.getItem(position).toString()
                // binding.spinnerMarcas.selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.botonFiltrar.setOnClickListener {
            //onClick
            Snackbar.make(binding.root, binding.spinnerMarcas.selectedItem.toString(), Snackbar.LENGTH_SHORT)
                .show()
        }

        binding.listViewModelos.setOnItemClickListener { parent, view, position, id ->


            //Snackbar.make(binding.root,"${resources.getString(R.string.mensaje)} "+listaCoches[position].precio.toString(), Snackbar.LENGTH_SHORT).show()

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("coche",DataSet.getAllModelos()[position])
            startActivity(intent)

        }

    }

    override fun onStart() {
        super.onStart()

    }
}