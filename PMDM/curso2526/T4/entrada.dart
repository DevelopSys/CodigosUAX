// fichero -> clases metodos/funciones variable
// clase -> clases
// metodos -> tipo_retorno nombre(){}
void main(){
  print("Primera app en Dart");
  // var y val -> mutable y no mutable
  // no mutables
  final DNI = "1234A";
  const NIF = "1234B";

  // mutables -> mutables fijas - mutables dinamicas
  String nombre = "Borja";
  String? correo = "borja@uax.com";
  late int telefono;
  late String apellido;

  // print("Mi nombre es "+nombre+" tengo un DNI con numero "+DNI);
  print("Mi nombre es $nombre tengo un DNI con numero $DNI");
  print("Mi correo es ${correo?.length ?? "sin correo"}");
  telefono = 1234;
  print("Mi telefono es $telefono");

  var direccion;
  direccion = "Madrid"; // String
  direccion = false; // bool
  direccion = 1234; // int

  // saludar("Borja");
  saludarNominales(nombre: "Juan",dia: "Martes");
  saludarNominales(dia: "Lunes");

}

// funciones -> retorno nombre (parametros
// saludar(nombre = "nombre")

saludar(String nombre, [String dia="Lunes"]){
  print("Procedemos a realizar el saludo correspondiente");
  print("Hola $nombre, bienvenido a la app dart, animo ya es $dia");
}

saludarNominales({String nombre="Luis", required String dia}){
  print("Procedemos a saludar nominalmente");
  print("Hola $nombre, animo que ya es $dia");
}