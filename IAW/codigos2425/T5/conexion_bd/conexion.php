<?php

// ejecutar la funcion mysqli() -> conectarme a una base de datos con unos permisos determinados
// servidor al que me conecto -> localhost
// usuario (root) pass () database (instituto)

/* define("username","root");
define("password","");
define("database","insituto");
define("server","localhost");
 */

const username = "root";
const password = "";
const database = "instituto";
const host = "localhost";

$connection = new mysqli(host, username, password, database);
if ($connection->connect_error) {
    echo "Error en conexion";
    die("error en la conection " . $connection->connect_error);
} else {
    echo "conexion realizada con exito";
}

?>