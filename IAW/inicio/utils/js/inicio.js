// codigo que se ejecutara junto con el HTML
// al pulsar un boton quiero que aparezca un mensaje
// necesito el boton -> referencia del elemento html
let botonPulsar;
let botonPulsar1;
window.addEventListener("load", () => {
  botonPulsar = document.querySelector("#boton1");
  botonPulsar1 = document.querySelector("#boton2");
  botonPulsar1.addEventListener("click", function () {
    confirm("Os habeis enterado de como funciona js?");
  });
  botonPulsar.addEventListener("click", function () {
    alert("Este es el primer proyecto realizado con JS");
  });
});
