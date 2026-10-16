package model

class Alumno(
    nombre: String,
    apellido: String,
    dni: String,
    telefono: Int,
    var notaMedia: Double
) : Persona(nombre,apellido,dni,telefono) {

    fun calcularUniversidad(){
        var notaUni = notaMedia*10;
    }

    //@Override
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("notaMedia = ${notaMedia}")
    }
}