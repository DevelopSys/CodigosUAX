package com.example.concesionario.model

import java.io.Serializable

class Modelo(
    var modelo: String,
    var marca: String,
    var precio: Int,
    var cv: Int,
    var descripcio: String,
    var imagen: Int
): Serializable