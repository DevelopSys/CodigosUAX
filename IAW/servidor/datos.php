<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title>Document</title>
</head>

<body>

    <main class="continer m-3">
        <p>Los datos obtenidos desde la pagina anterior son:</p>
        <p>

            
            <?php
            
            $id =  $_POST['id'];
            //mysql_queryi("SELECT * FROM LIGAS WHERE ID = $id");
            $nombre =  $_POST['nombre'];
            $apellido =  $_POST['apellido'];
            $edad =  $_POST['edad'];
            echo ("Nombre $nombre");
            echo ("Apellido $apellido");
            echo ("Edad $edad");
            if ($edad > 18) {
                echo ("Eres mayor de edad");
            } else {
                echo ("No puedes entrar en la pagina");
            }
            ?>


        </p>
    </main>

</body>

</html>