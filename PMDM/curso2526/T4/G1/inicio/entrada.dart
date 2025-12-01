// fichero -> class - variable - metodo/funciones
// Clase -> class 
// retorno? nombre (tipo nombre){cuerpo}
import 'dart:math';

void main(){
  /*
  print("Primera app Dart");
  // variable -> val no mutable var mutable
  // constantes
  const DNI = "1234A";
  final NIF = 1234;
  // mutables
  // tipo nombre = valor
  String nombre = "Borja";
  int edad = 42;
  bool acierto = false;
  // print("Mi nombre es "+nombre+" y tengo "+edad+" años");
  print("Mi nombre es $nombre y tengo $edad años");
  String? correo;
  print("Mi correo es ${correo ?? "sin correo"}");
  // mutable pero dinamica
  var direccion;
  direccion = "Madrid";
  print("La direccion del usuario es ${direccion*2}");
  direccion = 101;
  print("La direccion del usuario es ${direccion*4}");

   */
  // saludar("Juan","Viernes");
  // saludar("Borja");
  // saludar("Hola","Adios","asdasd");
  saludarNominal(mes: 1, nombre: "Juan");
}

// retorno nombre (argumentos ){}
void saludar(String dia,String mes,[String nombre="Borja"]){
  print("Enhorabuena $nombre has completado la primera funcion de dart");
  print("Estamos a $dia");
}

/*
void saludarNominal ({var nombre, var mes}){
  print("El nombre a saludar es $nombre");
  print("El mes introducido es $mes");
}*/
void saludarNominal ({String? nombre=null, required int mes}){
 if (nombre==null){
   print("El elemento a saludar es nulo");
 } else {
   print("Saludamos a $nombre en el mes numero $mes");
 }
}