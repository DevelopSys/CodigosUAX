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
        <h2>Formularios</h2>

        <form action="procesar.php" method="post">
            <input type="text" placeholder="Introduce tu nombre" class="form-control mb-3" name="nombre">
            <input type="text" placeholder="Introduce tu apellido" class="form-control mb-3" name="apellido">
            <input type="email" placeholder="Introduce tu correo" class="form-control mb-3" name="email">
            <input type="password" placeholder="Introduce tu pass" class="form-control mb-3" name="pass">
            <div class="row">
                <input type="submit" class="btn btn-primary col" value="Procesar datos">
                <button id="boton-vaciar" class="btn btn-danger col">Vaciar</button>
            </div>
            <script>
                let boton = document.querySelector("#boton-vaciar")
                boton.addEventListener("click", () => { })
            </script>
        </form>

        <form action="venta.php" method="post">
            <input type="text" placeholder="Introduce tu nombre" class="form-control mb-3" name="nombre">
            <input type="text" placeholder="Introduce tu apellido" class="form-control mb-3" name="apellido">
            <input type="email" placeholder="Introduce tu correo" class="form-control mb-3" name="email">
            <input type="password" placeholder="Introduce tu pass" class="form-control mb-3" name="pass">
            <div class="row">
                <input type="submit" class="btn btn-primary col" value="Procesar datos">
                <button id="boton-vaciar" class="btn btn-danger col">Vaciar</button>
            </div>
            <script>
                let boton = document.querySelector("#boton-vaciar")
                boton.addEventListener("click", () => { })
            </script>
        </form>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>