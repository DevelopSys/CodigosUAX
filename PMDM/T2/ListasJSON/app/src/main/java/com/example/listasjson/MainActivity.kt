package com.example.listasjson

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.listasjson.adapter.UsuariosAdapter
import com.example.listasjson.databinding.ActivityMainBinding
import com.example.listasjson.model.User
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<User>
    private lateinit var adaptadorUsuariosAdapter: UsuariosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaUsuarios = ArrayList()
        adaptadorUsuariosAdapter = UsuariosAdapter(listaUsuarios,this)

        binding.recyclerUsuarios.adapter =adaptadorUsuariosAdapter
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.spinnerGenero.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val genero = binding.spinnerGenero.selectedItem.toString()
                // creo la peticion
                val url = "https://randomuser.me/api/?results=50&gender=${genero}"
                val peticion: JsonObjectRequest = JsonObjectRequest(url, {
                    getContacts(it)
                }, {
                    Log.v("conexion", "conexion incorrecta")
                })

                //val peticion2 = JsonObjectRequest(Method.POST,url,null,{},{})
                // la añado a la lista de peticion
                Volley.newRequestQueue(applicationContext).add(peticion)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    fun creacionAudio() {
        var posicion: Int = 0;
        val media: MediaPlayer = MediaPlayer.create(this,R.raw.audio)

        // android.resources://${packageName}/R.raw.nombrevideo
packageName

        media.seekTo(posicion)
        media.start()

        media.stop()

        media.pause()
        posicion = media.currentPosition

    }

    fun getContacts(response: JSONObject): Unit {
        listaUsuarios.clear()
        val results = response.getJSONArray("results")
        for (i in (0..results.length()-1)){
            val user = results.getJSONObject(i)
            val name = user.getJSONObject("name").getString("first")
            val last = user.getJSONObject("name").getString("last")
            val email = user.getString("email")
            val phone = user.getString("phone")
            val picture = user.getJSONObject("picture").getString("medium")
            listaUsuarios.add(User(name, last, email, phone, picture))
            adaptadorUsuariosAdapter.notifyDataSetChanged()
        }

        Log.v("conecion", listaUsuarios.size.toString())
    }
}