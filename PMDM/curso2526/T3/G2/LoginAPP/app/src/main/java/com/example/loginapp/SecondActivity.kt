package com.example.loginapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginapp.adapters.ProductoAdapter
import com.example.loginapp.databinding.ActivitySecondBinding
import com.example.loginapp.model.Producto
import com.example.loginapp.ui.dialog.DialogoAyuda
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var adapter: ProductoAdapter
    lateinit var lista: ArrayList<Producto>
    lateinit var database: FirebaseDatabase
    lateinit var uid: String
    lateinit var pass: String

    var correo: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        instancias()
        recuperarDatos()
        asociarDatos()
    }

    private fun instancias() {

        database =
            FirebaseDatabase.getInstance("https://uaxg2-738ef-default-rtdb.europe-west1.firebasedatabase.app/")

        lista = arrayListOf(
            Producto("Pizza", "Italiana", R.drawable.paella),
            Producto("Hamburguesa", "Americana", R.drawable.hamburg),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Paella", "Española", R.drawable.paella),
            Producto("Sushi", "Japonesa", R.drawable.hamburg)
        )
        adapter = ProductoAdapter(lista)
    }

    private fun asociarDatos() {
        binding.listaProductos.adapter = adapter

        if (resources.configuration.orientation == 1) {
            binding.listaProductos.layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.VERTICAL, false
            )
        } else {
            binding.listaProductos.layoutManager =
                GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        }


        // Linear (Horizontal / Vertical)
        // Grid (Horizontal / Vertical)
        // Staggered (Horizontal / Vertical)
    }

    private fun recuperarDatos() {
        correo = intent.getStringExtra("correo")!!
        uid = intent.getStringExtra("uid")!!
        pass = intent.getStringExtra("pass")!!
        database.reference.child("usuarios").child(uid).child("correo").setValue(correo)
        database.reference.child("usuarios").child(uid).child("pass").setValue(pass)

        binding.textoCorreo.text = correo
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_ayuda -> {
                val dialogo = DialogoAyuda()
                dialogo.show(supportFragmentManager, null)
            }

            R.id.item_cerrar -> {
                Log.v("menu", "has puelsado el item salir")
                finish()
            }

            R.id.item_guardar -> {
                database.reference.child("usuarios").child(uid).child("dato").setValue(false)
            }
            R.id.item_consultar -> {
                database.reference.child("usuarios").child(uid)
                    .addListenerForSingleValueEvent(object : ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {

                        }

                        override fun onCancelled(error: DatabaseError) {

                        }
                    })
            }
        }
        return true
    }
}