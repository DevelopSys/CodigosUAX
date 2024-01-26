package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

// MainActivity extends AppCompactActivity implements OnClickListener
class MainActivity : AppCompatActivity() {

    // Button
    lateinit var botonPulsar: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // junta logica (this) con la parte grafica (xml)
        setContentView(R.layout.activity_main)
        // accede a los elementos graficos
        botonPulsar = this.findViewById(R.id.boton_pulsar);
        botonPulsar.setOnClickListener {
            Snackbar.make(it, "Práctica completada", Snackbar.LENGTH_SHORT).show()
        }
    }

}