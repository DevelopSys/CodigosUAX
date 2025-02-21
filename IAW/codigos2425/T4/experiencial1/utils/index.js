let inputNombre = document.querySelector("#inputNombre");
let inputPrecio = document.querySelector("#inputPrecio");
let inputDescripcion = document.querySelector("#inputDescripcion");
let inputFecha = document.querySelector("#inputFecha");
let selectCategoria = document.querySelector("#selectCategoria");
let botonEnvio = document.querySelector("#botonEnviar");
let botonVaciar = document.querySelector("#btnVaciar");
let listaProductos = document.querySelector("#listaProductos");

let descripcionPrueba = "";

botonEnvio.addEventListener("click", () => {
  let categoria = selectCategoria.value;
  let fecha = inputFecha.value;
  let descripcion = inputDescripcion.value;
  let precio = parseFloat(inputPrecio.value);
  let nombre = inputNombre.value;

  if (nombre.length > 0 && fecha.length > 0 && descripcion.length > 0) {
    if (descripcion.includes("Camiseta") && categoria != "Ropa") {
      Swal.fire({
        icon: "warning",
        title: "Los datos no casan",

        showConfirmButton: false,
        timer: 4000,
      });
    } else {
      /* Swal.fire({
        icon: "success",
        title: "Producto agregado correctamente",
        showConfirmButton: true,
        timer: 3000,
      }); */
      // agregar el producto Nombre - categoria - precio a la lista - modificar el innerHTML
      /* listaProductos.innerHTML =
        listaProductos.innerHTML +
        `<li class='list-group-item animate__animated animate__backInRight'>${nombre} - ${categoria} - ${precio} </li>`; */
      // crear un li <li></li>
      let nodoLI = document.createElement("li");
      // le pongo contenido -> text
      nodoLI.textContent = `${nombre} - ${categoria} - ${precio}`;
      // le pongo class
      nodoLI.className =
        "list-group-item animate__animated animate__backInRight";
      // añado a la lista ul
      listaProductos.appendChild(nodoLI);
    }
  } else {
    Swal.fire({
      icon: "warning",
      title: "Comprueba todos los datos",
      showConfirmButton: false,
      timer: 4000,
    });
  }

  /*   console.log("Categoria " + categoria);
  console.log("Fecha " + fecha);
  console.log("Descripcion " + descripcion);
  console.log("Nombre " + nombre);
  console.log("Precio " + precio); */
});

botonVaciar.addEventListener("click", () => {
  console.log("Pulsar");
  let liLista = document.querySelectorAll("#listaProductos li");
  liLista.forEach((element) => {
    element.classList.remove("animate__backInRight");
    element.classList.add("animate__wobble");
  });

  setTimeout(() => {
    liLista.forEach((element) => {
      element.classList.remove("animate__wobble");
      element.classList.add("animate__backOutRight");
    });

    setTimeout(() => {
      listaProductos.innerHTML = "";
    }, 500);
  }, 1000);
});
