/* funtions */
let divProducts = document.querySelector("#rowProducts");

fetch("https://dummyjson.com/products")
  .then((res) => {
    // traducir la respuesta en JSON
    return res.json();
  })
  .then((res2) => {
    // JSON traducido

    res2.products.forEach((item) => {
      divProducts.innerHTML += `<div class="col">
          <div class="card">
            <img src="${item.thumbnail}" class="card-img-top" style="width:50%" alt="..." />
            <div class="card-body">
              <h5 class="card-title">${item.title}</h5>
              <p class="card-text">
                ${item.description}
              </p>
            </div>
          </div>
        </div>`;
    });
  })
  .catch((rej) => {
    console.log("conexion incorrecta");
  });
