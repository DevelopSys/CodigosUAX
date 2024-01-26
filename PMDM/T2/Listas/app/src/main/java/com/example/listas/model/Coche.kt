package com.example.listas.model

import java.io.Serializable

class Coche (var nombre: String,var marca: String, var precio: Int, var cv: Int, var imagen: String) : Serializable {

    override fun toString(): String {
        return nombre
    }
}