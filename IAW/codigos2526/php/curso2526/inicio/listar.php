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



    <main class="conteiner m-4">

        <h2>Listado de usuarios</h2>
        <?php
        $query = "SELECT nombre, apellido, correo, telefono FROM alumnos";
        $results = $conn->query($query)
            ?>

        <?php if ($results && $results->num_rows > 0): ?>
            <ul class="list-group">
                <?php while ($row = $results->fetch_assoc()): ?>
                    <li class="list-group-item">
                        <?php echo ($row['nombre']) ?>
                        <?php echo (" " . $row['apellido']) ?>
                        <?php echo (" " . $row['correo']) ?>
                    </li>
                <?php endwhile; ?>

            </ul>
        <?php else: ?>
            <p>No hay resultados dentro de la consulta</p>

        <?php endif; ?>


    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
        </script>
</body>

</html>