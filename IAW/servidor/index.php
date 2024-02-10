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
    <main class="container m-3">
        <h1>Pagina realizada en PHP</h1>
        <?php
        $nombre = "Borja";
        echo ("Parte del código escrita en php realizada por $nombre")
        ?>
        <p>Esto es un primer ejemplo de pagina que vamos a realizar para crear un formulario</p>
        <div>
            <form method="post" action="datos.php">
                <input class="form-control" type="text" placeholder="Por favor introduce tu nombre" name="nombre">
                <input class="form-control" type="text" placeholder="Por favor introduce tu apellido" name="apellido">
                <input class="form-control" type="number" placeholder="Por favor introduce tu edad" name="edad">
                <input type="submit" class="btn btn-primary">Pulsar</button>
            </form>

        </div>
    </main>
</body>

</html>