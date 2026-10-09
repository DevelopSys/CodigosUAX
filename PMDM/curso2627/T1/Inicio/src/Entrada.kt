import kotlin.math.exp

// main -> entrada a la ejecicion
// static es elemento que pertenece a la clase, no al objeto
// public static void main(String [] args){  }
// Entrada.main()
// new Entrada().main()
// String nombre = "";
// int edad = 42;
// fun nombreMetodo(argumento: Tipo): Retorno {}
fun main() {
    // var -> esta variable es mutable. Puede alterar su valor
    // val -> esta variable es inmutable. No puede alterar su valor
    var nombre: String = "Borja" // null
    nombre = "Juan"
    val dni: String = "1234A" // null
    var correo: String? = "asdasd@gmail.com"
    lateinit var direccion: String

    println("Indica tu nombre")
    nombre = readln()
    println("Indica tu edad")
    var edad: Int = readln().toInt() // Integer.parseInt("asdasd")
    // String.format("Mi nombre es %s y mi dni es %s",nombre, dni)
    /*println("Mi nombre es $nombre y mi dni $dni")
    println("La longitud de mi correo es ${correo?.length ?: "0"}")
    direccion = "Ejemplo"
    println(direccion)*/
    saludar("Borja", 7) // uso de parametros posicionales
    saludar("Borja") // veces = 1
    saludar() // nombre = "Borja" veces = 1
    saludar(nombre = "Maria", veces = 8) // nominales
}

fun saludar(nombre: String = "Borja", veces: Int = 1) {
    // for (int i =0;i<10;i++){} foreach
    for (i in 0..veces - 1) {
        println("Enhorabuena $nombre, reto superado")
    }
}

fun sentenciasControl() {
    // for (i in 20 downTo 10)
    var numero = if (true) 4 else 6
    /*
    switch(valor){
        case 1->{}
        case 1->{}
        case 1->{}
        case 1->{}
        case 1->{}
        case 1->{}
        defailt ->{}
    }
     */
    var valor = 5;
    var dato = when (valor) {
        1 ->
            3

        2 ->
            4

        3 ->
            5

        4 ->
            6

        else ->
            7

    }
}

