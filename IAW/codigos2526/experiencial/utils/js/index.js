// una variable que "guarde" el puntero del objeto boton
/* function name(params) {
    // lo que se hace en la funcion
} */
/* (param)=>{ 
    // cuerpo
 } */

const boton = document.querySelector("#btn-registro");
const botonVaciar = document.querySelector("#btn-vaciar");
const parrafo = document.querySelector("p");
const inputNombre = document.querySelector("#input-nombre");
const inputApellido = document.querySelector("#input-apellido");
const inputPass = document.querySelector("#input-pass");
const inputCorreo = document.querySelector("#input-correo");
const selectCiclo = document.querySelector("#select-ciclo");
const lista = document.querySelector(".list-group");

boton.addEventListener("click", (event) => {
  /* parrafo.innerText =
    "Esta pagina ha sido modificada dinamicamente desde la pulsacion de un boton"; */
  // parrafo.classList.add("text-primary");

  let nombre = inputNombre.value;
  let apellido = inputApellido.value;
  let correo = inputCorreo.value;
  let pass = inputPass.value;
  let ciclo = selectCiclo.value;
  if (
    ciclo == "0" ||
    nombre.length == 0 ||
    apellido.length == 0 ||
    correo.length == 0 ||
    pass.length == 0
  ) {
    Swal.fire({
      position: "center",
      icon: "error",
      title: "Faltan datos",
      showConfirmButton: false,
      timer: 3000,
    });
  } else {
    // lista.innerHTML += `<li class='list-group-item animate__animated animate__backInRight'>${nombre} - ${correo} - ${ciclo}</li>`;
    let nodoLI = document.createElement("li");
    nodoLI.textContent = `${nombre} - ${correo} - ${ciclo}`;
    nodoLI.classList.add(
      "list-group-item",
      "animate__animated",
      "animate__backInRight",
    );

    let nodoBoton = document.createElement("button");
    nodoBoton.classList.add("btn", "btn-danger");
    nodoBoton.textContent = "Eliminar";
    nodoBoton.addEventListener("click", () => {
      // animate__backOutRight
      nodoLI.classList.remove("animate__backInRight");
      nodoLI.classList.add("animate__backOutRight");
      setTimeout(() => {
        nodoLI.remove();
      }, 700);
    });

    nodoLI.append(nodoBoton);
    lista.append(nodoLI);

    Swal.fire({
      title: "Agregado correctamente",
      icon: "success",
      showConfirmButton: false,
      timer: 3000,
      showClass: {
        popup: `
      animate__animated
      animate__fadeInUp
      animate__faster
    `,
      },
      hideClass: {
        popup: `
      animate__animated
      animate__fadeOutDown
      animate__faster
    `,
      },
    });
  }
});

botonVaciar.addEventListener("click", (event) => {
  lista.innerHTML = "";
});
