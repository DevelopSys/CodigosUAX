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
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var adapter: ProductoAdapter
    lateinit var lista: ArrayList<Producto>
    lateinit var correo: String
    lateinit var uid: String;
    lateinit var pass: String;
    lateinit var database: FirebaseDatabase;

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
            FirebaseDatabase.getInstance("https://uaxg1-c2d8f-default-rtdb.asia-southeast1.firebasedatabase.app/")
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
        pass = intent.getStringExtra("pass")!!
        uid = intent.getStringExtra("uid")!!
        binding.textoCorreo.text = correo
        val userRef = database.reference.child("usuarios").child(uid)
        userRef.child("correo").setValue(correo)
        userRef.child("pass").setValue(pass)
        userRef.child("uid").setValue(uid)
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

            R.id.item_insertar -> {
                // referencia -> child
                database.reference.child("nombreAPP").setValue("APP UAX")
            }

            R.id.item_borrar -> {
                database.reference.child("nombreAPP").setValue(null)

            }

            R.id.item_consulta -> {
                database.reference.child("usuarios").child(uid)
                    .addChildEventListener(object : ChildEventListener{
                        override fun onChildAdded(
                            snapshot: DataSnapshot,
                            previousChildName: String?
                        ) {
                        }

                        override fun onChildChanged(
                            snapshot: DataSnapshot,
                            previousChildName: String?
                        ) {
                            Log.v("datos","Los datos han cambiado")
                            // actualizar algo de la UI
                            Log.v("datos",snapshot.value.toString())
                            for (i in snapshot.children){
                                Log.v("datos",i.toString())
                            }
                        }
                        override fun onChildRemoved(snapshot: DataSnapshot) {
                        }

                        override fun onChildMoved(
                            snapshot: DataSnapshot,
                            previousChildName: String?
                        ) {
                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                    })

            }
        }
        return true
    }
}