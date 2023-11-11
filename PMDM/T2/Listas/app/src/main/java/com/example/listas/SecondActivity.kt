package com.example.listas

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.example.listas.databinding.ActivitySecondBinding
import com.example.listas.model.Usuario

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // nombreUsuario = null
        binding.nombreUsuario.text = (intent.extras?.getSerializable("usuario")
                as Usuario).nombre
        binding.spinnerMarcas.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // parent?.adapter?.getItem(position).toString()
                // binding.spinnerMarcas.selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.spinnerMarcas.setOnClickListener {  }
        binding.botonFiltrar.setOnClickListener {
            //onClick
            binding.spinnerMarcas.selectedItem
        }
    }

    override fun onStart() {
        super.onStart()
        // binding.recycerModelos - parte grafica
        // datos - ArrayAdapter - RecyclerView.Adapter - ArrayList
    }
}