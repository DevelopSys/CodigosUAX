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
        <h1 class="text-center">Colecciones</h1>
        <?php
        $alumnos = ["Borja"];
        echo ("<p>Prodecemos a mostrar el tamaño del array </p>");
        $alumnos[] = "Marta"; // situado en la ultima posicion de la coleccion
        $alumnos[] = "Jorge"; // situado en la ultima posicion de la coleccion
        // echo (count($alumnos));
        // Borja, Marta, Jorge
        array_push($alumnos, "Maria", "Juan", "Pedro");


        array_unshift($alumnos, "Julian", "Celia", "Rebeca");
        //Jualian,Celia, Rebeca Borja, Marta, Jorge, Maria, Juan, Pedro
        $alumnos[0] = "Carla";
        //Carla,Celia, Rebeca Borja, Marta, Jorge, Maria, Juan, Pedro
        
        echo (count(($alumnos)));
        ?>

        <p>Vamos a crear una lista con todos los alumnos del centro</p>
        <?php

        crearLista($alumnos)
            ?>

        <p>Procedemos a realizar operaciones de eliminacion</p>
        <?php
        unset($alumnos[0]);
        $alumnos = array_values($alumnos);
        crearLista($alumnos);
        array_pop(array: $alumnos); // elimina el ultimo elemento del array
        array_shift(($alumnos)); // elimina el primer elemento del array
        echo ("Eliminados principio y final");
        crearLista($alumnos)

            ?>
        <p>Procedemos a eliminar un elemento en una posicion desconicida</p>
        <input class="form-control">
        <?php
        $posicion = array_search("Jorge", $alumnos);
        if ($posicion !== false) {
            unset($alumnos[$posicion]);
            $alumnos = array_values($alumnos);
            echo ("<p>Elemento borrado con exito</p>");
        } else {
            echo ("<p>El elemento qye intentas borrar no esta en la lista</p>");
        }

        crearLista($alumnos)

            ?>

        <?php
        function crearLista($array)
        {
            echo ("<ul class='list-group'>");
            foreach ($array as $data) {
                # code...
                echo ("<li class='list-group-item'>" . $data . "</li>");
            }
            echo ('</ul>');
        }
        ?>
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>