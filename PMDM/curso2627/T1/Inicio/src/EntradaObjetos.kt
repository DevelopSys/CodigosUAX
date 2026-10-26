import model.Alumno
import model.Director
import model.Evaluable
import model.Persona
import model.Profesor

fun main() {


    var profesor = Profesor("Profe1", "Apellido1", "123123", 234234, 1000)
    var alumno = Alumno("Alumno", "ApellidoA", "123123A", 123123, 6.75)
    var director = Director("Director", "ApellidoA", "123123A", 123123, 67)

    var lista: ArrayList<Persona> = arrayListOf() // [P,P,P,P]
    lista.add(profesor)
    lista.add(alumno)
    lista.add(director)
    lista.add(Alumno("Alumno2", "ApellidoA2", "123123AF", 123123, 6.75))

    // lista[1]

    // for foreach
    /*for (item in lista){
        item.mostrarDatos()
    }*/
    /*for (i in 0 until lista.size){
        lista[i].mostrarDatos()
    }*/

    // lista.forEach { item -> item.mostrarDatos() }
    // lista.forEach { it.mostrarDatos() } // si la funcion que defino solo tiene un parametro, puedes llamarlo it
    lista.forEachIndexed { index, item ->
        println("Persona en posicion $index")
        item.mostrarDatos()
        if (item is Evaluable) {
            println("El resulado de la evaluacion es ${item.evaluar()}")
        }

    }
    // 11111A
    val personaEncontrada: Persona? = lista.find { it.dni == "11111A"  } // null
    val listaFiltrada: List<Persona> = lista.filter { it.nombre?.contains("a") ?: false } // List = []
    /*for(PErsona item: lista){
        // no tengo la variable de posicion -> i
    }*/
}

