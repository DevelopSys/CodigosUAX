package com.example.contador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivityMainBinding

    private var contador: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.v("ciclo","ejecutando onCreate")

        contador = savedInstanceState?.getInt("contador")  ?: 0
        binding.textoContador .text = contador.toString();
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener {
            // onClick -> it: View!
        }
        binding.botonPasar?.setOnClickListener(this)
        binding.botonPasar2?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        // diferenciar quien ha pulsado
        when(v?.id){
            binding.botonIncremento.id->{
                contador++
            }
            binding.botonDecremento.id->{
                contador--
            }
            binding.botonPasar?.id->{
                val intent = Intent(applicationContext,SecondActivity::class.java)
                intent.putExtra("contador",contador)
                startActivity(intent)
            }
            binding.botonPasar2?.id->{
                val intent = Intent(applicationContext,SecondActivity::class.java)
                startActivity(intent)
            }
        }

        binding.textoContador.text = contador.toString()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // par clave - valor
        outState.putInt("contador",contador)

    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo","ejecutando onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo","ejecutando onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo","ejecutando onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo","ejecutando onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo","ejecutando onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo","ejecutando onDestroy")
    }
}