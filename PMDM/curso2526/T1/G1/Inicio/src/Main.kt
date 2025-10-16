// public static void main(String[]args){}

// fun nombreMetodo(nombre:Tipo, nombre2:Tipo):Retorno {}
fun main() {
    // variables -> primitivas (Int, Double, Float, Boolean) / complejas (String, Scanner)
    //           -> String nombre = "Borja"; nombre = "Borja M."
    //           -> final String DNI = "123A"
    //           -> var nombre: String = "Borja"
    //           -> val DNI: String = "1234A"

    var nombre: String = "Borja"
    nombre = "Borja M. H"
    val DNI = "123123A"
    var edad: Int? = 41
    var correoE: String? = null

    println("Mi nombre es $nombre y mi DNI es $DNI y mi nombre tiene ${nombre.length} letras")
    println("Mi correo es ${correoE ?: "sin definir"}")
    println("Mi correo tiene ${correoE?.length ?: "0"} letras")
    //funcionSaludar("Borja",1)
    // funcionSaludar(numeroVeces = 3, nombre = "Juan")
    // funcionSaludar(numeroVeces = 5)
    // recorrerElementos()
    // funcionFlecha(1,1.9,"Prueba")
    // recorrerElementos()

    var directivo1 = Directivo("BorjaD", "MartinD", 123123123)
    var trabajador1 = Trabajador("BorjaT", "MartinT", 1234, 30000)
    var trabajador2 = Trabajador("BorjaT", "MartinT", 1234, 30000)
    var directivo3 = Directivo("BorjaD", "MartinD", 123123123)
    var trabajador3 = Trabajador("BorjaT", "MartinT", 1234, 30000)
    var trabajador4 = Trabajador("BorjaT", "MartinT", 1234, 30000)
    var directivo2 = Directivo("BorjaD", "MartinD", 123123123)

    var listaUsuarios: ArrayList<Usuario> =
        arrayListOf(directivo1, trabajador1, trabajador2, trabajador3, trabajador4, directivo2, directivo3)

    // for ( Usuario item: listaUsuarios){}

    // si una funcion solo tiene un parametro no es necesario declararlo, utiliza IT
    listaUsuarios.forEach{  it.metodoVotar() }

}

var funcionFlecha = { p1: Int, p2: Double, p3: String -> println("La funcion ejecutara los parametros $p1 $p2 $p3") }

fun funcionSaludar(nombre: String = "Celia", numeroVeces: Int = 3) {
    /*when (numeroVeces) {
        1 -> {}
        2 -> {}
        3 -> {}
        4 -> {}
        !in 5..10 -> {}
        11, 12, 13 -> {}
        else -> {}
    }*/
    // while- dowhile
    // for(asd:asd){}

    for (i in 0..numeroVeces - 1) {
        println("Hola $nombre, tu primer programa de kotlin esta completo")
    }

}

fun recorrerElementos() {
    val palabras = arrayListOf<String>("Hola", "Programacion", "Android", "Kotlin", "AVD")
    for (item in palabras) {
        println(item)
    }
    // parametros -> cuerpo
    palabras.forEach { println(it) }
    palabras.filter { it.length == 7 }.forEach { print(it) }

    /*
    ArrayList filtrada = new ArrayList()
    ArrayList palanras = new ArrayList()
    for(item in palabras){
        if (item.length ==7){
        filtrada.add(item)
    }
    for(item in filtradas){
    sout(item)

     */

}

