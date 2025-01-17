// JSON (par clave - valor)
let objeto = {
  nombre: "Borja",
  apellido: "Martin",
  edad: 40,
  conocimentos: [
    { nombre: "js", nivel: "alto", aniosExperiencia: 10 },
    { nombre: "Linux", nivel: "alto", aniosExperiencia: 7 },
    { nombre: "java", nivel: "alto", aniosExperiencia: 15 },
    { nombre: "php", nivel: "alto", aniosExperiencia: 12 },
    { nombre: "kotlin", nivel: "alto", aniosExperiencia: 12 },
    { nombre: "python", nivel: "alto", aniosExperiencia: 12 },
  ],
};

// for -> recorrer uno a uno los elementos de una coleccion
/* for (let index = 0; index < objeto.conocimentos.length; index++) {
  const element = objeto.conocimentos[index];
  lista.innerHTML += `<li class="list-group-item">${element.nombre}</li>`;
} */
objeto.conocimentos.forEach((item) => {
  console.log(item);
  lista.innerHTML += `<li class="list-group-item">${item.nombre}</li>`;
});

let listaApi = document.querySelector("#lista-api");
let filaResultados = document.querySelector("#fila-resultados");
// pedirle los datos al servidor
fetch("https://dummyjson.com/users")
  .then((respuesta) => {
    return respuesta.json();
  })
  .then((respuesta1) => {
    //console.log(respuesta1);
    respuesta1.users.forEach((item) => {
      filaResultados.innerHTML += ` <div class="col mt-3">
      <div class="card" style="width: 14rem">
        <img src="${item.image}" class="card-img-top" alt="..." />
        <div class="card-body">
          <h5 class="card-title">${item.firstName} ${item.lastName}</h5>
          <p class="card-text">
            ${item.address.city}
          </p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
      </div>
    </div>`;
    });
  });
