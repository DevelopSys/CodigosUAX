open class Usuario(var nombre: String, var apellido: String) {

    // variables
    var telefono: Int? = null

    // constructores -> primarios(1) secundarios(n se basan en el primario)
    constructor(nombre: String, apellido: String, telefono: Int) : this(nombre, apellido) {
        this.telefono = telefono
    }

    // funciones
    open fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Telefono: ${telefono ?: "no hay telefono"}")
    }
}