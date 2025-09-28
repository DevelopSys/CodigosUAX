package com.example.usuarios

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.usuarios.dao.UserDAO
import com.example.usuarios.databinding.ActivityMainBinding
import com.example.usuarios.model.User

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnInsertar.setOnClickListener(this)
        binding.btnBorrar.setOnClickListener(this)
        binding.btnActualizar.setOnClickListener(this)
        binding.btnConsultar.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.btnInsertar.id->{
                val usuarioDAO = UserDAO(applicationContext)
                usuarioDAO.insertUser(User("Borja",40))
                usuarioDAO.insertUser(User("Pedro",41))
            }
            binding.btnBorrar.id->{

            }
            binding.btnActualizar.id->{

            }
            binding.btnConsultar.id->{
                val usuarioDAO = UserDAO(applicationContext)
                binding.numeroUsuarios.text = usuarioDAO.getUsers().toString()

            }
        }
    }
}