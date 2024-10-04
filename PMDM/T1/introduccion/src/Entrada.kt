// fun nombre(nombre:Tipo): TipoRetorno { cuerpo }
// (String[] args)
fun main() {

    println("Primer app en Kotlin")
    // var si el valor cambia en algun momento
    // val si el valor no cambia en ningun momento -> final
    // var nombre: Tipo = valor
    var nombre: String = "Borja"
    val edad: Int = 40;
    var apellido: String? = "Borja"
    println("Mi apellido es ${apellido ?: "sin apellido"} y la longitud del mismo es ${apellido?.length ?: "0"}") // NullPointerException
    lateinit var correo: String // no tiene valor ahora, pero lo tendrá
    correo = "borja@gmail.com"
    println(correo)
    println("El resultado de la operacion es ${sumar(7, 9)}");
    println("El resultado de la operacion es ${sumar(operandoUno = 5, operandoDos = 10)}");
    println("El resultado de la operacion es ${sumar(operandoDos = 10, operandoUno = 2)}");
    println("El resultado de la operacion es ${sumar(operandoDos = 4)}");
    println("El resultado de la operacion es ${sumar(4)}");
    println("El resultado de la operacion es ${multiplicar(6,6)}");
    // dividir(2)
    var usuario = Usuario(nombre = "Borja", apellido = "Martin")
    var usuario1 = Usuario(nombre = "Juan", apellido = "Gomez",1234567)
    var usuario2 = Usuario(nombre = "Celia", apellido = "Martin","celia@gmail.com")
    var usuario3 = UsuarioEspecializado(nombre = "Celia", apellido = "Martin",123123,"asdasd123")
    // usuario.mostrarDatos()
    // usuario1.mostrarDatos()
    // usuario2.mostrarDatos()
    usuario3.mostrarDatos()

}

fun sumar(operandoUno: Int = 2, operandoDos: Int = 10): Int {
    return operandoUno + operandoDos
}

val multiplicar = { operadorUno: Int, operadorDos: Int -> println(operadorUno * operadorDos) }
// val dividir = {  println(it) }