package com.example.loginapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.databinding.ItemProductoBinding
import com.example.loginapp.model.Producto
import com.google.android.material.snackbar.Snackbar

// 1-Extiendo de RecyclerView.Adapter
// 3- Pon el holder (la clase anidada) dentro del tipado
// 4- Implementa todos los metodos no implementados

class ProductoAdapter(var listaDatos: ArrayList<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {
    // 2- Creo la clase anidada ViewHolder
    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    // se encarga de crear el holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        return MyHolder(
            ItemProductoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // se encarga de pintar cada fila
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val producto = listaDatos[position]
        holder.binding.imagenFila.setImageResource(producto.icono)
        holder.binding.textoFila.setText(producto.nombre)
        holder.binding.imagenFila.setOnClickListener {
            Snackbar.make(
                holder.binding.root,
                "El tipo de comida es ${producto.tipo}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        holder.binding.textoFila.setOnClickListener {
            Snackbar.make(
                holder.binding.root,
                "El nombre de la comida es ${producto.nombre}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    // se encarga de indicar cual es el numero de filas que tengo que pintar (en total)
    override fun getItemCount(): Int {
        return listaDatos.size
    }


}