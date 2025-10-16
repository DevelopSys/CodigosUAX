// constructor primario -> todos aquellos datos obligatorios

abstract class Usuario(var nombre: String, var apellido: String) {

    var telefono: Int? = null

    // constructor secundario -> todos aquellos datos el primerio + algunos optativos
    constructor(nombre: String, apellido: String, telefono: Int):this(nombre,apellido) {
        this.telefono = telefono;
    }

    open fun mostrarDatos(){
        println("nombre = ${nombre}")
        println("apellido = ${apellido}")
        println("telefono = ${telefono}")
    }

    abstract fun metodoVotar()

}