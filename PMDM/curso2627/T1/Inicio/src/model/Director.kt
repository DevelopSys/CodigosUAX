package model

class Director(
    nombre: String?,
    apellido: String?,
    dni: String?,
    telefono: Int?,
    var participaciones: Int
) : Persona(nombre, apellido, dni, telefono), Evaluable {

    fun calcularParticipaciones() {
        var trienio = participaciones * 10;
    }

    //@Override
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("participaciones = ${participaciones}")
    }

    override fun evaluar(): Boolean {
        if (participaciones < 50)
            return false
        else if (participaciones >= 50)
            return true
        return false
    }
}