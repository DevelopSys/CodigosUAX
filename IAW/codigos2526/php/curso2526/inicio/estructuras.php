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

    <?php
    include("./menu.php")
        ?>

    <div class="container">

        <div class="row">
            <div class="col">
                <h2>IF</h2>
                <p>El if sirva para poder ejecutar una parte de codigo dependiendo de un valor booleano</p>
                <?php
                $nota = -6;
                $estado = false;
                if ($nota >= 0 && $nota <= 10) {
                    if ($nota < 5) {
                        echo ("<div class='alert alert-danger'>El alumno está suspenso</div>");
                    } else if ($nota < 8) {
                        echo ("<div class='alert alert-warning'>El alumno está aprobado</div>");
                    } else if ($nota < 10) {
                        echo ("<div class='alert alert-info'>El alumno está con muy buena nota</div>");
                    } else {
                        echo ("<div class='alert alert-success'>El alumno está con matricula</div>");
                    }
                } else {
                    echo ("<div class='alert alert-danger'>La nota introducida no es valida</div>");
                }

                ?>

            </div>
            <div class="col">
                <h2>switch</h2>
                <p>Estructura de control utilizada para poder seleccionar una ejecucion dependiendo de un valor</p>
                <?php
                $diaSemana = 2;
                switch ($diaSemana) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        echo ("<div class='alert alert-success'>El dia de la semana laborable</div>");
                        break;
                    case 5:
                        echo ("<div class='alert alert-info'>El dia de la semana es el sabado</div>");
                        break;
                    case 6:
                        echo ("<div class='alert alert-info'>El dia de la semana es el domingo</div>");
                        break;

                }
                ?>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h2>for</h2>
                <p>Se ejecuta una parte del codigo tantas veces como el rango indique</p>
                <!-- <ul class="list-group">
                    <?php
                    /* $operando = 7;
                    inicio, final, incremento
                    for ($i = 0; $i < 11; $i++) {
                        echo ("<li class='list-group-item'>El resultado de la operacion de multiplicar " . $operando . " y " . $i . " es " . ($operando * $i) . "</li>");
                    } */
                    ?>
                </ul> -->
                <table class="table">
                    <?php
                    $oprenado = 8;
                    for ($i = 0; $i < 11; $i++): ?>
                        <tr>
                            <td class="text-success"><?php echo $i ?></td>
                            <td class="text-success"><?php echo $oprenado ?></td>
                            <td class="text-success"><?php echo ($oprenado * $i) ?></td>
                        </tr>
                    <?php endfor; ?>

                    <?php
                    while ($a <= 10) {
                        # code...
                    }

                    do {
                        # code...
                    } while ($a <= 10)
                    ?>
                </table>

            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>