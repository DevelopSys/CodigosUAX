open class Usuario(var nombre: String, var apellido: String){

    // variables
    var telefono: Int? = null
    var correo: String? = null
    // constructores -> n
    // primarios -> 1 -> todas aquellas cosas que el objeto del tipo tiene que tener SI o SI
    // secundarios -> n -> tantos como quiera pero que dependan del primario
    constructor(nombre: String, apellido: String, telefono: Int): this(nombre,apellido) {
        this.telefono = telefono
    }

    constructor(nombre: String, apellido: String, correo: String): this(nombre,apellido) {
        this.correo = correo
    }
    // metodos
    open fun mostrarDatos() {
        println("Nombre $nombre")
        println("Apellido $apellido")
        println("Telefono ${telefono?:"sin telefono"}")
        println("Correo ${correo?:"sin correo"}")
    }

}