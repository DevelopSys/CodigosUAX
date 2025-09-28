class UsuarioEspecializado(nombre: String, apellido: String, telefono: Int, var dni: String) :
    Usuario(nombre, apellido, telefono), Programable {
    // lo mismo que el usuario + DNI
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("DNI $dni")
    }

    override fun programar(x: Int) {

    }


}