package com.example.concesionario.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.concesionario.R
import com.example.concesionario.model.Marca

class AdaptadorMarcas(var listaMarcas: ArrayList<Marca>, var contexto: Context) : BaseAdapter() {

    override fun getCount(): Int {
        // cuantas filas se pintaran
        return listaMarcas.size
    }

    override fun getItem(p0: Int): Marca {
        // el item de cada fila
        return listaMarcas[p0]
    }

    override fun getItemId(p0: Int): Long {
        // el id de cada fila
        return p0.toLong();
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // el aspecto de cada fila -> necesito el XML
        // EL XML
        val view: View = LayoutInflater.from(contexto).inflate(R.layout.item_marca, p2, false)
        val imagen = view.findViewById<ImageView>(R.id.imagenLogoSp)
        val texto = view.findViewById<TextView>(R.id.textMarcaSP)

        // necesito la marca para capturar sus propiedades
        val marca: Marca = listaMarcas[p0]
        imagen.setImageResource(marca.logo)
        texto.text = marca.nombre
        return view;

    }
}