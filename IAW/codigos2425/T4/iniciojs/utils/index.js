let boton = document.querySelector("#botonEnviar");
let inputNombre = document.querySelector("#inputNombre");
let inputs = document.querySelectorAll(".btn-primary");
console.log("Esto es un mensaje desde un fichero");
// variables
// se puede cambiar su valor
// no se puede cambiar su valor -> constantes

// busqueda por clase / etiqueta / id
// console.log(inputs);
// console.log(boton);
boton.textContent = "Pulsado por mi";

boton.addEventListener("click", () => {
  alert("Enhorabuena, reto completado " + inputNombre.value);
});

let nombre = "Borja"; // string -> palabra -> "xxxxxxxxx"
nombre = "BorjaM";
let edad = 40; // number -> int float
edad = edad + 1; // 41
const DNI = "123123A";
let experiencia = false; // boolean -> true / false

if (experiencia == true) {
  console.log("El usuario tiene experiencia");
  // te pinto de verde un div y ademas te pongo una animacion
} else {
  console.log("No tiene experiencia");
  // te pingo de amarillo el div y te saco un cuadro de dialogo avisandote
}
