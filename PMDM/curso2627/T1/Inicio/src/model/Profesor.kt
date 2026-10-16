package model

class Profesor(
    nombre: String?,
    apellido: String?,
    dni: String?,
    telefono: Int?,
    var salario: Int
) : Persona(nombre, apellido, dni, telefono), Evaluable {

    fun calcularTrienios() {
        var trienio = salario * 10;
    }

    //@Override
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("salario = ${salario}")
    }

    override fun evaluar(): Boolean {
        if (salario > 1000)
            return true
        return false
    }
}