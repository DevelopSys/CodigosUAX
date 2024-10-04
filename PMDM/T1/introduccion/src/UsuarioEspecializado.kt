class UsuarioEspecializado(nombre: String, apellido: String, telefono: Int, var dni: String) :
    Usuario(nombre, apellido, telefono) {
    // lo mismo que el usuario + DNI
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("DNI $dni")
    }
}