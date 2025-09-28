package com.example.almacenamiento

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.almacenamiento.dao.UserDAO
import com.example.almacenamiento.databinding.ActivityMainBinding
import com.example.almacenamiento.model.User

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBorrar.setOnClickListener(this)
        binding.btnInsertar.setOnClickListener(this)
        binding.btnActualizar.setOnClickListener(this)
        binding.btnSeleccionar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnBorrar.id->{
                val userDAO= UserDAO(applicationContext)
                userDAO.deleteUser("Borja")
            }
            binding.btnInsertar.id->{
                val userDAO= UserDAO(applicationContext)
                userDAO.insertUser(User("Borja",40))
            }
            binding.btnActualizar.id->{
                val userDAO= UserDAO(applicationContext)
                userDAO.updateUser("Borja")
            }
            binding.btnSeleccionar.id->{
                val userDAO= UserDAO(applicationContext)
                binding.textView.text = userDAO.getUsers().toString()
            }
        }
    }
}