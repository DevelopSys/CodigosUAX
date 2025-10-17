package model

class Director(nombre: String, apellido: String, telefono: Int, var nivelResponsabilidad: Int) :
    Usuario(nombre, apellido, telefono) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("nivelResponsabilidad = ${nivelResponsabilidad}")
    }

    override fun realizarTrabajo() {
        println("Yo soy director y tengo mucha responsabildad "+nivelResponsabilidad)
    }

    fun aumentarResponsablidad() {
        nivelResponsabilidad++;
    }
}