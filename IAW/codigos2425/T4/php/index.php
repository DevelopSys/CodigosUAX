<!-- codigo HTML y PHP -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>
    <title>Document</title>
</head>

<body>

    <div class="container">
        <h1>App con php</h1>
        <p>Esta pagina la vamos a utilizar para explicar las bases de PHP</p>
        <!-- comentario en HTML -->
        <?php
        // comentario de php
        echo "<p>Esto es un parrafo escrito en PHP</p>";
        $asignatura = "IAW";
        $alumnos = ["Maria", "Claudia", "Juan", "Luis"];
        $curso = "ASIR";
        $profesor = "Borja Martin";
        $horas = 45;
        $numeroAlumnos = 0;
        $nota_media = 7.48;
        $troncal = false;
        define("codigo_asignatura", 1234);
        define("codigo_curso", 12);

        echo "<h3>Asignatura $asignatura</h3>";
        echo "<p>Asignatura que pertenece al curso $curso que tiene un codigo de asignatura " . codigo_asignatura . ". Vamos a mostrar las caracteristicas de la asignatura</p>";
        echo "<ul class='list-group'><li class='list-group-item'>Horas: $horas</li><li class='list-group-item'>Alumnos: $numeroAlumnos</li><li class='list-group-item'>Media: $nota_media</li><li class='list-group-item'>Troncal $troncal</li></ul>";

        echo "<h3>Información de alumnos</h3>";
        echo "<p>El numero total de alumnos matriculados son:" . count($alumnos) . "</p>";
        echo "<p>El primer alumno/a en matricularse ha sido: $alumnos[0]</p>";
        echo "<p>El último alumno/a en matricularse ha sido: " . $alumnos[count($alumnos) - 1] . "</p>";

        echo "<p>Vamos a realizar matriculaciones</p>";
        // agregar elementos dentro de un array -> se agregan al final
        $alumnos[] = "Mateo";
        array_push($alumnos, "Marcos", "Juan", "Pedro", "Maria", "Marta");
        echo "<p>El numero total de alumnos despues de las matriculaciones es de: " . count($alumnos) . "</p>";
        // elimina un elemento en concreto, el de la posicion indicada
        unset($alumnos[0]);
        // recoloca todos los elementos en sus posiciones
        array_values($alumnos);
        // "Maria","Claudia","Juan","Luis","Marta","Luis","Pepe","Julia","Marcos","Juan","Pedro","Maria","Marta"
        $listaFiltrada =  array_filter($alumnos, function ($element) {
            return $element != "Julia";
        });
        $numeroAlumnosFiltro = count($listaFiltrada);
        echo "<p>El numero de alumnos que se llaman Marta es de $numeroAlumnosFiltro</p>";
        echo "<p>El numero de alumnos que se llaman Marta es de" . count(value: $listaFiltrada) . "</p>";
        /* $numero1=4; // number
            $numero2="4"; // string
            $numero1==$numero2; // true
            $numero1===$numero2; // false */
        ?>

        <h2>Estructuras de control</h2>
        <p>Las estructuras de control sirven para realizar saltos logicos dentro de nuestro codigo</p>
        <h3>IF - IF/ELSE - IF / ELSEIF/ ELSE</h3>
        <!-- quiero poner diferentes avisos, dependiendo del numero de alumnos que tengo en matricula -->
        <!-- si hay < 10 alumnos -> no comienza el curso, necesito mas alumnos -->
        <!-- si hay  10-19 alumnos -> comienza el curso, pero admito mas alumnos -->
        <!-- si hay  20-25 alumnos -> estamos a pocos alumnos del limite -->
        <!-- si hay  >25 alumnos -> curso completo -->
        <?php
        if (count($alumnos) < 10) {
            echo "No comienza el curso, pocos alumnos";
        } else if (count($alumnos) < 20) {
            echo "comienza el curso, admito mas alumnos";
        } else if (count($alumnos) < 25) {
            echo "Curso cerca del limite";
        } else {
            echo "Curso completo";
        }

        ?>
        <h3>Estructura SWITCH</h3>
        <!-- se ejecuta una parte, dependiendo del valor de una variable -->
        <?php
        $alumnos[] = "nuevo";

        echo  "El numero de alumnos actual es de " . count($alumnos) . " alumnos";
        switch (count($alumnos)) {
            case 10:
                echo "<p>Numero de alumnos insuficientes</p>";
                break;
            case 13:
                echo "<p>Numero de alumnos medio</p>";
                break;
            case 20:
                echo "<p>Numero de alumnos perfecto</p>";
                break;
            default:
                echo "<p>Caso no contemplado</p>";
        }
        ?>

        <h3>Estrucutra while y dowhile</h3>
        <?php
        unset($alumnos[0]);
        // recoloca todos los elementos en sus posiciones
        array_values($alumnos);
        $valor = 5;
        do {
            echo "<p>La variable es positiva</p>";
            $valor--; // resta uno
        } while ($valor > 0)
        ?>
        <h3>Estrucutra FOR</h3>
        <!-- alumno1 alumno2 alumno3 alumno4 alumno5 0  count-1 -->
        <!-- $alumnos[4] -->
        <ul class="list-group">
            <?php
            echo "numero de alumnos " . count($alumnos) . "total";
            // empiezo en 0 $alumnos[0]
            // termino en count-1 $alumnos[9]
            // 0 ; <10
            for ($i = 0; $i < count($alumnos); $i++) {
                echo "<li class='list-group-item'>" . $alumnos[$i] . "</li>";
            }

            ?>
        </ul>



    </div>

</body>

</html>