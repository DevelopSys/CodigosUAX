// codigo que se ejecutara junto con el HTML
// al pulsar un boton quiero que aparezca un mensaje
// necesito el boton -> referencia del elemento html
let botonPulsar;
let botonPulsar1;
let contador = 0;
let lista = document.querySelector("ul");
let inputNombre = document.querySelector("#inputnombre");
let inputEdad = document.querySelector("#inputedad");
let botonAgregar = document.querySelector("#botonagregar");
let botonVaciar = document.querySelector("#botonvaciar");
let parrafo = document.querySelector("p");

botonAgregar.addEventListener("click", () => {
  let nombre = inputNombre.value;
  let edad = Number(inputEdad.value);
  console.log(edad + 1);
  inputNombre.value = "";
  if (nombre.length > 0) {
    lista.innerHTML =
      lista.innerHTML + `<li class='list-group-item'>${nombre}</li>`;
    actualizarTextoNumeroHijo();
    /*  let nodoLI = document.createElement("li");
    // crear un nodo li
    nodoLI.className = "list-group-item";
    nodoLI.textContent = nombre;
    // darle valor del input
    lista.append(nodoLI);
    // añadirlo a la lista
    // MODIFICAR EL DOM DINAMICAMENTE */
  } else {
    alert("No se puede agregar, faltan datos");
  }

  /* contador++;
  parrafo.textContent = contador; */
});

botonVaciar.addEventListener("click", () => {
  // lista.innerHTML = "";
  // lista.remove();
  // lista.removeChild(document.querySelector("#idhijo1"))

  if (lista.children.length > 0) {
    // 4-1
    // [123,123,123,1,asd,asd,asd,asd,asd,asd,asd]
    lista.removeChild(lista.children[lista.children.length - 1]);
    actualizarTextoNumeroHijo();
  } else {
    alert("No puedes borrar porque no hay hijos");
  }
});

function actualizarTextoNumeroHijo() {
  parrafo.textContent = `El numero de hijos actual es ${lista.children.length}`;
}

/* function nombre() {
  //console.log("Ejecutado");
} */

//botonAgregar.textContent = "Pulsar modificado";

// los elementos que cumplen (lista nodos)
let botonAgregar1 = document.querySelectorAll("button");

/* botonPulsar = document.querySelector("#boton1");
botonPulsar1 = document.querySelector("#boton2");
botonPulsar1.addEventListener("click", function () {
  confirm("Os habeis enterado de como funciona js?");
});
botonPulsar.addEventListener("click", function () {
  alert("Este es el primer proyecto realizado con JS");
}); */

// OKPulsar el boton, OKcoger el elemento del input y ponerlo en la lista
