package com.example.saludo

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saludo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // private lateinit var btn: Button
    // asocia parte grafica y parte logica
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // la parte grafica se junta con la logica
        binding.editNombre.setText("Prueba")
        binding.btnSaludar.setOnClickListener {
            var nombre = binding.editNombre.text.toString()
            if (!nombre.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Enhorabuena $nombre, has completado el reto",
                    Snackbar.LENGTH_LONG
                ).show()

                binding.editNombre.text.clear()
            }
        }

    }
}