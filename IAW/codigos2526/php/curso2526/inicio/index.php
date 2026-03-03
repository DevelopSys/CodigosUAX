<!-- llamar al fichero donde se definen todas las contantes -->
<?php
include "./config.php";
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Variables</title>
</head>

<body>

    <?php
    include("./menu.php")
        ?>

    <div class="container my-3">
        <h1 class="text-center text-success mb-4">Aplicación PHP Variables</h1>
        <p>Esta pagina nos servirá para poder explicar el uso de variables dentro de PHP.
            <?php
            // funcion llamada desde php - echo -> imprime lo indicado dentro de la funcion 
            echo ("Esta funcion la estamos llamando desde una etiqueta dentro del html");
            ?>
        </p>
        <div class="row">
            <div class="col">
                <h2 class="text-center text-warning">Variables no constantes</h2>
                <p>Las variables no contantes se usan para poder almacenar datos que seran alterados. Para poder definir
                    una variable no cosntante se usa el simbolo $</p>
                <?php
                $nombre = "Borja";
                $edad = 42;
                ?>

                <div class="alert alert-primary">
                    Mi nombre es <?php echo ($nombre); ?> y tengo <?php echo $edad; ?> años
                </div>

                <p>Despues de este parrafo vamos a modificar el valor de una variabe</p>

                <?php
                //  $edad = $edad+ 1;
                $edad += 1;
                ?>

                <div class="alert alert-success">
                    Despues de cumplir años, mi edad es de <?php echo $edad; ?> años
                </div>

            </div>
            <div class="col">
                <h2 class="text-center text-danger">Variables constantes</h2>
                <p>Aquellas que guardan datos, pero no puedo alterar su valor. Para poder declarar una variable
                    constante se utiliza la función define()</p>

                <?php
                // definicion de constantes en este .php
                define("DNI", "1234A")
                    ?>

                <div class="alert alert-danger">
                    Mi DNI es
                    <?php echo (DNI); ?>
                </div>

                <p>Si quieres puedes acceder a variables creadas desde otro fichero siempre y cuando lo hayas llamado
                    con un include</p>
                <div class="alert alert-warning">
                    Asignatura <?php
                    echo (ASIGNATURA)
                        ?>
                </div>


            </div>


        </div>

        <div class="row">
            <p>Los diferentes tipos de datos que no podemos encontrar en PHP son</p>
            <?php
            $nombre = "Borja";
            $edad = 42;
            $altura = 1.72;
            $experiencia = false;
            $hobbies = ["futbol", "videojuegos", "lectura"];
            ?>
            <ul class="list-group">
                <li class="list-group-item">Texto - String <?php echo $nombre ?></li>
                <li class="list-group-item">Numeros enteros - Integer <?php echo $edad ?></li>
                <li class="list-group-item">Numeros decimales - Float <?php echo $altura ?></li>
                <li class="list-group-item">Boolean true / false - Bool <?php echo $experiencia ?></li>
                <li class="list-group-item">Listas conjunto de cosas [] - Array <?php echo ($hobbies[1]) ?></li>
            </ul>
        </div>

        <div class="row mt-3">
            <h2 class="text-center text-success">Operaciones</h2>
            <!-- Las operaciones son las aritmeticas -->
            <?php
            // suma uno
            

            $modulo = $numero % 2;
            ?>
            <p>Los resultados de las operaciones son: </p>
            <p>Arimeticas (+,-,* y /) <?php
            $numero = 18;
            $numero++;
            $numero++;
            $numero *= 5; // a lo que vale edad le multiplicas 2 y lo vuelves a guardar $edad = $edad *2
            $numero /= 1; // a lo que vale edad le divides 2 y lo vuelves a guardar 
            $numero += 20; // a lo que vale edad le sumas 2 y lo vuelves a guardar 
            $numero -= 5; // a lo que vale edad le restas 2 y lo vuelves a guardar 
            echo ($numero);
            ?> </p>
            <p>Módulo (%) - resto de la division <?php echo ($modulo); ?> </p>
        </div>


    </div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>