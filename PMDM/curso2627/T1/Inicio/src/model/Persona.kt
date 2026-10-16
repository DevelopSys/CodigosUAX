package model

open class Persona(var nombre: String?=null, var apellido: String?=null, var dni: String?=null, var telefono: Int?=null) {

    // atributos -> getter y setter implicitos
    // var telefono : Int? = null;
    // constructores -> primarios (solo 1 primario) y secundarios  (constructor siempre herencia del primario)
    /*
    public Persona(String nombre){
        this.nombre= nombre
    }
     */
    /*
    constructor(nombre: String, apellido: String, dni: String, telefono: Int) : this(nombre,apellido,dni)  {
        this.telefono = telefono;
    }*/
    // funciones
    open fun mostrarDatos(): Unit{
        println("nombre = ${nombre}")
        println("apellido = ${apellido}")
        println("dni = ${dni}")
        println("telefono = ${telefono}")
    }


    // getter / setter
}