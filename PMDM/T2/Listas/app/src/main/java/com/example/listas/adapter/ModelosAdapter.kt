package com.example.listas.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ModelosAdapter : RecyclerView.Adapter<ModelosAdapter.Myholder>() {

    class Myholder(var view: View,): ViewHolder(view) {

    }

    override fun getItemCount(): Int {
        // indicar cuantos elementos tiene la lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        // asociar la parte grafica (XML - aspecto de la fila) con el patron
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
        // asocia al patron los datos de la lista en una  posicion
    }

}