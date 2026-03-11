<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <title>Document</title>
</head>

<body>

    <?php include('./menu.php'); ?>
    <?php include('./config.php'); ?>

    <!-- disponible en php la variable $conn -->

    <main class="conteiner m-4">
        <h2>Agregar alumno</h2>
        <form method="post" action="./agregar.php">
            <input type="text" placeholder="Introduce tu nombre" class="form-control mb-3" name="nombre">
            <input type="text" placeholder="Introduce tu apellido" class="form-control mb-3" name="apellido">
            <input type="text" placeholder="Introduce tu correo" class="form-control mb-3" name="email">
            <input type="number" placeholder="Introduce tu telefono" class="form-control mb-3" name="telefono">
            <input type="submit" class="btn btn-primary" value="Procesar datos">
        </form>

    </main>

    <?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {

        $nombre = $_POST['nombre'] ?? '';
        $apellido = $_POST['apellido'] ?? '';
        $mail = $_POST['email'] ?? '';
        $telefono = $_POST['telefono'] ?? 0;
        $query = "INSERT INTO alumnos (nombre, apellido, correo, telefono) VALUES (?,?,?,?)";
        $pstm = $conn->prepare(query: $query);
        $pstm->bind_param("sssi", $nombre, $apellido, $mail, $telefono);
        echo (($pstm));
        if ($pstm->execute()) {
            echo ("Insertado correctamente");
        } else {
            echo ("Inserción erronea");
        }
        $pstm->close();
        $conn->close();
    }
    // INSERT INTO XX (asd,asd,asd,asd) VALUES ('asd','asd','asd',123)
    // statement -> query "escrita a mano"
    // preparestatement -> query param
    ?>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>