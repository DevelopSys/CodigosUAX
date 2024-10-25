package com.example.estado1

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estado1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recuperar los datos que se han guardado

        contador = savedInstanceState?.getInt("contador") ?: 0
        binding.txtPalabras.text = contador.toString()

        binding.btnAnadir.setOnClickListener(this)
        binding.btnReset?.setOnClickListener(this)
        binding.checkEdicion.setOnCheckedChangeListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnAnadir.id -> {
                // añadir 1 al contador
                if (binding.editText.text.isNotEmpty()) {
                    contador++
                    binding.txtPalabras.text = contador.toString()
                    binding.editText.text.clear()
                }
            }

            binding.btnReset?.id -> {
                contador = 0
                binding.txtPalabras.text = contador.toString();
            }
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            binding.checkEdicion.id -> {
                binding.editText.isEnabled = isChecked
                /*if (binding.checkEdicion.isChecked){
                // si esta en true se pone el edit en activado
                    binding.editText.isEnabled = true
                } else {
                // si esta en false se pone el edit en desactivado
                    binding.editText.isEnabled = false
                }*/
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // ejecutado justo antes de la ejecucion del onDestroy
        outState.putInt("contador", contador)
    }
}