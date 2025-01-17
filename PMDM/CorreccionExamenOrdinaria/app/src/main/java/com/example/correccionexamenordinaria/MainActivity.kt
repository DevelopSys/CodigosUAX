package com.example.correccionexamenordinaria

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.correccionexamenordinaria.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {

            val mediaRetos: Double = binding.spReto1.selectedItem.toString()
                .toDouble() + binding.spReto2.selectedItem.toString()
                .toDouble() + binding.spReto3.selectedItem.toString().toDouble()

            if (binding.editNota.text.isEmpty()){
                Snackbar.make(binding.root,"Faltan datos por introducir",Snackbar.LENGTH_SHORT).show()
            } else {
                val mediaTotal = (mediaRetos/3)*0.3 + binding.editNota.text.toString().toDouble() * 0.7
                if (mediaTotal<5){
                    Snackbar.make(binding.root, "No has aprobado", Snackbar.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(applicationContext, SecondActivity::class.java)
                    intent.putExtra("media",mediaTotal)
                    startActivity(intent)
                }
            }
        }

    }
}