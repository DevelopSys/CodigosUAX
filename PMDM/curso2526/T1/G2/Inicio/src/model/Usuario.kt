package model

// constructores primarios -> aquellos que tienen los datos obligatorios del objeto
abstract class Usuario(var nombre: String, var apellido: String) {

    var telefono: Int?=null;

    // constructores secundarios -> aquellos basados en el primario que añaden datos (no todos lo tienen que tener)
    constructor(nombre: String, apellido: String, telefono: Int):this(nombre,apellido){
        this.telefono = telefono;
    }

    open fun mostrarDatos(){
        println("nombre = ${nombre}")
        println("apellido = ${apellido}")
        println("telefono = ${telefono ?: "sin indicar"}")
    }

    abstract fun realizarTrabajo()

    // atributos
    // constructores -> q por defecto a no ser que escriba uno
    // getter setter -> para acceder o modificar a las caracteristicas del objeto, por los atributos son private

}