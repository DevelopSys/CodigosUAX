package com.example.loginapp.model

import java.io.Serializable

class Usuario(
    var nombre: String,
    var apellido: String,
    var edad: Int,
    var correo: String,
    var localizacion: String,
) : Serializable