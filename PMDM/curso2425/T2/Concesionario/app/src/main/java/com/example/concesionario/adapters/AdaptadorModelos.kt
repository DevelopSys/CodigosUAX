package com.example.concesionario.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.concesionario.R
import com.example.concesionario.model.Modelo
import com.example.concesionario.ui.DetailActivity

class AdaptadorModelos(var lista: ArrayList<Modelo>, var context: Context) :
    RecyclerView.Adapter<AdaptadorModelos.MyHolder>() {

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        // saco cada uno de los elementos que hay dentro del XML (patron de la fila)
        val boton = itemView.findViewById<Button>(R.id.btnModelo)
        val texto = itemView.findViewById<TextView>(R.id.textoModelo)
        val imagen = itemView.findViewById<ImageView>(R.id.imagenModelo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // crea el patron de las filas
        val vista = LayoutInflater.from(context).inflate(R.layout.item_modelo, parent, false)
        val holder: MyHolder = MyHolder(vista)
        return holder;
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // como se comporta cada fila
        val modelo = lista[position]
        holder.imagen.setImageResource(modelo.imagen)
        holder.texto.text = modelo.modelo
        holder.boton.setOnClickListener {

            val intent = Intent(context, DetailActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val bundle = Bundle()
            bundle.putSerializable("coche",modelo)
            intent.putExtra("datos",bundle)
            context.startActivity(intent)
        }
        holder.imagen.setOnLongClickListener {
            lista.remove(modelo)
            notifyItemRemoved(position)
            true
        }
    }

    fun actualizarLista(listaModelos: ArrayList<Modelo>) {
        this.lista = listaModelos;
        notifyDataSetChanged()
    }

}