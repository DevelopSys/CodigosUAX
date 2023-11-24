package com.example.listas.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listas.DetailActivity
import com.example.listas.R
import com.example.listas.data.DataSet
import com.example.listas.model.Coche

class AdapterModelos(var lista: ArrayList<Coche>, var contexto: Context) : RecyclerView.Adapter<AdapterModelos.ModeloHolder>() {

    // patron
    class ModeloHolder(vista: View): RecyclerView.ViewHolder(vista){
        // extraer cada elemento del patron -> imagen, textview
        var imagenImageView: ImageView
        var textoTextView: TextView

        init {
            imagenImageView = vista.findViewById(R.id.imagen_fila)
            textoTextView = vista.findViewById(R.id.nombre_fila)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModeloHolder {
        // como se crea el patron
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_modelo,parent,false)
        return ModeloHolder(vista);
    }

    override fun getItemCount(): Int {
      // numero de elementos que tendra que adaptar
        return lista.size
    }

    fun addCoche(coche: Coche): Unit {
        lista.add(coche)
        notifyItemInserted(lista.size-1)
    }

    override fun onBindViewHolder(holder: ModeloHolder, position: Int) {
        // representa cada elemento de la lista en su posicion (utilizando el patron)
        val item = lista[position]
        holder.textoTextView.text = item.nombre
        Glide.with(contexto).load(item.imagen).into(holder.imagenImageView)
        holder.imagenImageView.setOnClickListener {
            val intent = Intent(contexto, DetailActivity::class.java)
            intent.putExtra("coche", DataSet.getAllModelos()[position])
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            contexto.startActivity(intent)
        }

    }


}