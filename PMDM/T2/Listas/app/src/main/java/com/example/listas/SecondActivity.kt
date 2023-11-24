package com.example.listas

import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.adapter.AdapterModelos
import com.example.listas.data.DataSet
import com.example.listas.database.DBHelper
import com.example.listas.database.SchemaDB
import com.example.listas.databinding.ActivitySecondBinding
import com.example.listas.model.Coche
import com.example.listas.model.Usuario
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    // parte de datos de mi lista
    private lateinit var adaptadorLista: ArrayAdapter<Coche>
    private lateinit var adapterModelos: AdapterModelos
    private lateinit var openHelper: DBHelper;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openHelper = DBHelper(applicationContext,SchemaDB.DB_NAME, 1)

        // nombreUsuario = null
        // ctx, layout, lista
        // adaptadorLista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,DataSet.getAllModelos());
        //binding.listViewModelos.adapter = adaptadorLista;
        adapterModelos = AdapterModelos(openHelper.getCoches(),applicationContext)
        binding.recyclerModelos.adapter =  adapterModelos
        binding.recyclerModelos.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,
            false)

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
                //adaptadorLista.clear()
                //adaptadorLista.addAll(listaFiltrada)
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
            /*Snackbar.make(binding.root, binding.spinnerMarcas.selectedItem.toString(), Snackbar.LENGTH_SHORT)
                .show()*/
            val coche = Coche("Nuevo","Marca",20000,200,"https://cdn.motor1.com/images/mgl/6ZpX4E/s1/2022-ford-mondeo-china-debut.jpg")
            openHelper.agregarCoche(coche)
            adapterModelos.addCoche(coche)
        }


        /*binding.listViewModelos.setOnItemClickListener { parent, view, position, id ->

            //Snackbar.make(binding.root,"${resources.getString(R.string.mensaje)} "+listaCoches[position].precio.toString(), Snackbar.LENGTH_SHORT).show()

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("coche",DataSet.getAllModelos()[position])
            startActivity(intent)

        }*/

    }

    override fun onStart() {
        super.onStart()

    }
}