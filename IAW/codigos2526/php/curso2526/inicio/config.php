<?php
define("ASIGNATURA", "IAW");
define("CICLO", "ASIR");
define("AUTOR", "Borja");
// 127.0.0.1:3306 -> cambiar por el de mi host de db
$host = "localhost";
$user = "root";
$pass = "";
$db = "alumnos_uax";
$conn = new mysqli($host, $user, $pass, $db, 3308);
if ($conn->connect_error) {
    die("Conexion erronea para los datos indicados");
}
?>