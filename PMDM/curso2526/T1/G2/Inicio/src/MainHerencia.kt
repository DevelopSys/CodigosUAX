import model.Director
import model.Trabajador
import model.Usuario

fun main() {
    var trabajador1 = Trabajador("Juan1", "Lopez", 70000)
    var trabajador2 = Trabajador("Juan2", "Lopez", 30000)
    var trabajador3 = Trabajador("Juan3", "Lopez", 60000)
    var director1 = Director("Marta4", "Gomez", 123123, 5)
    var director2 = Director("Marta5", "Gomez", 123123, 1)
    var director3 = Director("Marta6", "Gomez", 123123, 3)

    val listaUsuario = arrayListOf(trabajador3, trabajador2, trabajador1, director3, director2, director1)
    // for foreach for(Usuario item: listaUsuarios) {}
    listaUsuario.forEach { it.realizarTrabajo() }

}