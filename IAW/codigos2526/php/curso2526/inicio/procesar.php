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



    <main class="conteiner m-4">
        <h2>Procesamiento</h2>
        <p>Vamos a recuperar los datos pasados desde metodo POST/GET</p>
        <?php
        $nombre;
        $apellido;
        $correo;
        $pass;
        echo ("<p>");
        if ($_SERVER['REQUEST_METHOD'] === 'GET') {
            echo ("Datos pasados por POST");
            $nombre = $_GET['nombre'];
            $apellido = $_GET['apellido'];
            $mail = $_GET['email'];
            $pass = $_GET['pass'];
            echo ("<p>" . $nombre . "</p>");
            echo ("<p>" . $apellido . "</p>");
            echo ("<p>" . $mail . "</p>");
            echo ("<p>" . $pass . "</p>");
        } else if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            echo ("Datos pasados por POST");
            $nombre = $_POST['nombre'];
            $apellido = $_POST['apellido'];
            $mail = $_POST['email'];
            $pass = $_POST['pass'];
            echo ("<p>" . $nombre . "</p>");
            echo ("<p>" . $apellido . "</p>");
            echo ("<p>" . $mail . "</p>");
            echo ("<p>" . $pass . "</p>");
        }
        echo ("</p>");
        ?>



    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>