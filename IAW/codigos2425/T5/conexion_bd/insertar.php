<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
</head>

<body>
    <!-- captura parametros -->
    <h1>Conexion con base de datos</h1>
    <p>Se procede a insertar el dato</p>
    <?php
  require("conexion.php");
  $nombre = $_POST['nombre'];
  $correo = $_POST['mail'];
  $pass = $_POST['pass'];
  $telefono = $_POST['telefono'];
  $sql = "INSERT INTO alumnos (nombre, correo, pass, telefono) VALUES ('" . $nombre . "','" . $correo . "','" . $pass . "'," . $telefono . ")";
  if ($connection->query($sql) === TRUE) {
    echo "<p>Insercion del usuario " . $nombre . " correcta</p>";
  } else {
    echo "<p>Fallo en insercion</p>";
  }
  $connection->close();
  ?>
</body>

</html>