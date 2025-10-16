class Trabajador(nombre: String, apelido: String, telefono: Int, var sueldo: Int)
    : Usuario(nombre, apelido, telefono) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("sueldo = ${sueldo}")
    }

    override fun metodoVotar() {
        println("El trabajador esta votando")
        println("Su voto no cuenta mucho")
        println("Es un trabajador")
    }


}