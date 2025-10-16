class Directivo(nombre: String, apellido: String, var participaciones: Int)
    : Usuario(nombre, apellido) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("participaciones = ${participaciones}")
    }

    override fun metodoVotar() {
        println("El directivo vota, y su voto es el que manda")
    }
}