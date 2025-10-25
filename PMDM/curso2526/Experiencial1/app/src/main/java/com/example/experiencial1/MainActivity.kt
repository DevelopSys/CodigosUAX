package com.example.experiencial1

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.experiencial1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // https://brandmentions.com/wiki/images/c/cd/Wordle_logo.png
    //binding.edit10.background = resources.getDrawable(R.drawable.fondo_edit_verde)

    lateinit var binding: ActivityMainBinding
    lateinit var palabras: Array<String>
    lateinit var palabra: String
    lateinit var letrasPalabra: CharArray
    lateinit var fila1: ArrayList<EditText>
    lateinit var fila2: ArrayList<EditText>
    lateinit var fila3: ArrayList<EditText>
    lateinit var fila4: ArrayList<EditText>
    lateinit var filas: Array<ArrayList<EditText>>
    var intento: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()

        acciones()
    }

    private fun instancias() {
        palabras = arrayOf(
            "arbol",
            "pluma",
            "fuego",
            "nieve",
            "perro",
            "gatos",
            "cielo",
            "carta",
            "luzco",
            "pieda",
            "silla",
            "casas",
            "reloj",
            "flaco",
            "duros",
            "tigre",
            "noche",
            "campo",
            "niños",
            "pared",
            "barco",
            "raton",
            "botas",
            "lanza",
            "hojas",
            "pasto",
            "vuelo",
            "rojas",
            "verde",
            "blusa",
            "monte",
            "queso",
            "vacas",
            "diente",
            "sueño",
            "amigo",
            "mujer",
            "huevo",
            "coche",
            "canto",
            "ramos",
            "pinta",
            "cabra",
            "ronda",
            "salta",
            "mango",
            "rubia",
            "negro",
            "blanco",
            "arena",
            "rural",
            "suelo",
            "tocar",
            "habla",
            "leche",
            "mueve",
            "baila",
            "niega",
            "poder",
            "temor",
            "carne",
            "punta",
            "campo",
            "firme",
            "dulce",
            "costo",
            "borde",
            "rueda",
            "techo",
            "clavo",
            "brazo",
            "miedo",
            "demon",
            "tonto",
            "vacio",
            "santo",
            "caida",
            "matar",
            "plato",
            "hielo",
            "pesar",
            "reina",
            "sello",
            "tarde",
            "pobre",
            "lejos",
            "campo",
            "vigor",
            "metal",
            "firma",
            "poema",
            "causa",
            "senda",
            "guapo",
            "lento",
            "nacer",
            "paseo",
            "zorro",
            "burro",
            "trigo"
        )
        palabra = palabras.random()
        letrasPalabra = palabra.toCharArray();
        fila1 = ArrayList<EditText>()
        fila2 = ArrayList<EditText>()
        fila3 = ArrayList<EditText>()
        fila4 = ArrayList<EditText>()
        fila1 = arrayListOf(
            binding.edit10,
            binding.edit11,
            binding.edit12,
            binding.edit13,
            binding.edit14
        )
        fila2 = arrayListOf(
            binding.edit20,
            binding.edit21,
            binding.edit22,
            binding.edit23,
            binding.edit24
        )
        fila3 = arrayListOf(
            binding.edit30,
            binding.edit31,
            binding.edit32,
            binding.edit33,
            binding.edit34
        )
        fila4 = arrayListOf(
            binding.edit40,
            binding.edit41,
            binding.edit42,
            binding.edit43,
            binding.edit44
        )
        // addChild(fila1, binding.fila1)
        // addChild(fila2, binding.fila2)
        // addChild(fila3, binding.fila3)
        // addChild(fila4, binding.fila4)
        filas = arrayOf(fila1, fila2, fila3, fila4)

        Log.v("palabra_seleccionada", palabra)
        Log.v("palabra_seleccionada", letrasPalabra.get(0).toString())
    }

    private fun addChild(fila: ArrayList<EditText>, donde: LinearLayout) {

        for (i in 0..donde.childCount) {
            fila.add(donde.getChildAt(i) as EditText)
        }

    }

    private fun acciones() {
        binding.botonEvaluar.setOnClickListener {
            val palabraEvaluar = binding.editEvaluar.text.toString();

            palabraEvaluar.length ==5

            val letrasEvaluar = palabraEvaluar.toCharArray();
            // evaluarPalabra()
            // 1 2 3 4 5
            // 1 2 3 4 5
            /*
            for (i in 0..4) {
                /*
                when(i){
                    0->{evaluarPalabra(fila1,palabraEvaluar,letrasEvaluar)}
                    1->{evaluarPalabra(fila2,palabraEvaluar,letrasEvaluar)}
                    2->{evaluarPalabra(fila3,palabraEvaluar,letrasEvaluar)}
                    3->{evaluarPalabra(fila4,palabraEvaluar,letrasEvaluar)}
                }*/
            }*/
            evaluarPalabra(filas[intento], palabraEvaluar, letrasEvaluar)
            binding.editEvaluar.text.clear()
            intento++;

        }
    }

    private fun evaluarPalabra(
        fila: ArrayList<EditText>,
        palabraEvaluar: String,
        letrasEvaluar: CharArray
    ) {

        var contadorInvalido: Int = 0;
        for (i in 0..palabraEvaluar.length - 1) {

            if (palabraEvaluar == palabra) {
                Snackbar.make(binding.root, "Enhorabuena, juego completado", Snackbar.LENGTH_SHORT)
                    .show()
            } else if (letrasEvaluar.get(i) == letrasPalabra.get(i)) {
                fila.get(i).background = resources.getDrawable(R.drawable.fondo_edit_verde)
                fila.get(i).setText(letrasEvaluar.get(i).toString())
            } else if (palabra.contains(palabraEvaluar.get(i))) {
                fila.get(i).background = resources.getDrawable(R.drawable.fondo_edit_amarillo)
                contadorInvalido++
            } else {
                fila.get(i).background = resources.getDrawable(R.drawable.fondo_edit_rojo)
                contadorInvalido++
            }


        }

        if (intento == 3 && contadorInvalido > 0) {
            binding.botonEvaluar.isEnabled = false
            val snackbar = Snackbar.make(
                binding.root,
                "${resources.getString(R.string.text_loser)} asd",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction(R.string.button_snack) {
                intento = 0
                contadorInvalido = 0
                // pon en gris todos los fondos
                palabra = palabras.random();
                snackbar.dismiss()
            }
            snackbar.show()

        }
    }

    private fun initGUI() {
        Glide.with(applicationContext)
            .load("https://brandmentions.com/wiki/images/c/cd/Wordle_logo.png")
            .into(binding.imagenLogo)
    }
}