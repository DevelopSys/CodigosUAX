// variables
// funciones
// void -> Unit
// public static void main(){}
fun main(){

    // sumar(2,4)
    // variables que pueden cambiar su valor -> mutable
    var operandoUno: Int= 8
    operandoUno = 4
    // variables que no pueden cambiar su valor -> no mutable
    val operandoDos = 7
    var nombre: String? = null
    // yo se que esta variable en algun momento tendrá valor, pero de inicio NO
    lateinit var apellido: String
    println(nombre?.length ?: "No hay nombre" )
    apellido = "ejemplo"
    println("Mi apellido es $apellido" )
    println("El resultado de la suma es ${sumar(4,6)}")
    println(sumar(operandoDos=5, operandoUno = 10))
    println(multiplicar(4,3))
    println(multiplicar(operandoDos = 3))
    println(multiplicar())
    println("El resultado de la funcion dividir es ${dividir(6,3)}")
    println("El resultado de la funcion duplicar es ${duplicar(6)}")
    var usuario = Usuario(nombre = "Borja", apellido = "Martin")
    var usuario1 = Usuario(nombre = "Borja", apellido = "Martin", telefono = 123)
    usuario.mostrarDatos()
    usuario1.nombre= "Sad"
}

fun sumar(operandoUno: Int, operandoDos: Int): Int{
    return operandoDos+operandoUno
}
fun multiplicar(operandoUno: Int=1, operandoDos: Int=10): Int{
    return operandoDos*operandoUno
}

val dividir = { operandoUno: Int, operandoDos: Int -> operandoUno/operandoDos }

val duplicar = { operando: Int -> operando*2}
