package model

class Trabajador(nombre: String, apellido: String, var sueldo: Int) : Usuario(nombre,apellido) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("sueldo = ${sueldo}")
    }

    override fun realizarTrabajo() {
        println("El trabajador realiza todo el trabajo")
        if (sueldo>50000){
            println("Trabajo mucho para ganar mucho")
        } else {
            println("Trabajo poco porque cobro poco")
        }
    }

    fun metodoTrabajador(){
        println("Comenzando la jornada laboral")
    }
}