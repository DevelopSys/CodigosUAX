package com.example.listas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var ciclos: ArrayList<CharSequence>
    private lateinit var adapterCiclos: ArrayAdapter<CharSequence>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()


        binding.btnEnviar.setOnClickListener(this)
        // la interfaz tiene dos metodos
        binding.spinnerHabilitado.onItemSelectedListener = this
        binding.spinnerCiclos.onItemSelectedListener = this

    }

    private fun instancias() {
        ciclos = arrayListOf("DAM", "DAW")
        // contexto -> getapplicationctx
        // vista -> vista que me da android
        // lista -> que quiero mostrar
        adapterCiclos = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, ciclos)
        adapterCiclos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCiclos.adapter = adapterCiclos
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btnEnviar.id -> {
                binding.imagen.setImageResource(R.mipmap.ic_launcher)
                // el seleccionado del spinner
                /*val seleccionado: String = binding.spinnerOpciones.selectedItem.toString()
                Snackbar.make(
                    binding.root,
                    "El seleccionado es ${seleccionado}",
                    Snackbar.LENGTH_SHORT
                ).show()*/
                ciclos.add("AF")
                adapterCiclos.notifyDataSetChanged()
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0?.id){
            binding.spinnerHabilitado.id->{
                val seleccion: String = p0.adapter.getItem(p2).toString();
                Snackbar.make(binding.root,seleccion, Snackbar.LENGTH_SHORT).show()
                if (p2==0){
                    binding.btnEnviar.isEnabled = true
                } else {
                    binding.btnEnviar.isEnabled = false
                }
            }
            binding.spinnerCiclos.id->{
                val seleccion: CharSequence = adapterCiclos.getItem(p2)!!
                binding.textoCiclo.text = seleccion
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}