package com.example.listas2

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listas2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listaCiclos: ArrayList<CharSequence>
    private lateinit var adapterCiclos: ArrayAdapter<CharSequence>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        binding.btnEnviar.setOnClickListener(this)
        binding.btnBorrar.setOnClickListener(this)
        binding.spinnerHabilitado.onItemSelectedListener = this
        binding.spinnerCiclos.onItemSelectedListener = this

    }

    private fun instancias() {
        listaCiclos = arrayListOf("DAM", "DAW")
        // 1-> applicationctx
        // 2-> como se muestran las filas -> android.R
        // 3-> lista
        adapterCiclos =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaCiclos)
        adapterCiclos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCiclos.adapter = adapterCiclos;


    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnEnviar.id -> {
                val seleccion = binding.spinnerHabilitado.selectedItem.toString()
                /*Snackbar.make(binding.root, "La seleccion es $seleccion", Snackbar.LENGTH_SHORT)
                    .show()*/
                val ciclo = binding.editCiclo.text.toString();
                listaCiclos.add(ciclo)
                adapterCiclos.notifyDataSetChanged()
            }
            binding.btnBorrar.id->{
                listaCiclos.remove(binding.editCiclo.text.toString());
                adapterCiclos.notifyDataSetChanged()
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0?.id) {
            binding.spinnerHabilitado.id -> {
                val seleccion = p0.adapter.getItem(p2).toString()
                /*Snackbar.make(binding.root, "La seleccion es $seleccion", Snackbar.LENGTH_SHORT)
                    .show()*/
                if (p2 == 1) {
                    binding.btnEnviar.isEnabled = true
                } else if (p2 == 2) {
                    binding.btnEnviar.isEnabled = false
                }

                binding.spinnerHabilitado.setSelection(0)
            }
            binding.spinnerCiclos.id ->{
                val seleccion = adapterCiclos.getItem(p2)
                binding.textoCiclo.text = seleccion.toString()
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}