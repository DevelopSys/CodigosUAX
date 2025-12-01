package com.example.loginapp.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAyuda : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 1-> crea un builder
        val builder = AlertDialog.Builder(requireContext())

        // 3 - configura como quieres que se comporte el cuadro
        // poner un titulo
        builder.setTitle("Dialogo de ayuda")
        // poner un contenido o una lista
        // builder.setMessage("Esta app ha sido realizada para la asignatura de PMDM")
        val opciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        /*
        builder.setItems(
            opciones,
            DialogInterface.OnClickListener { view, pos -> opciones[pos] }

        builder.setSingleChoiceItems(opciones, -1,
            DialogInterface.OnClickListener { view, pos -> })
             */

        val arraySeleccion: BooleanArray = booleanArrayOf(false,false,true)
        builder.setMultiChoiceItems(
            opciones,
            arraySeleccion,
            DialogInterface.OnMultiChoiceClickListener { view, pos, check -> })
        // poner los botones -> boton neutral boton negativo boton positivo
        builder.setPositiveButton(
            "OK",
            DialogInterface.OnClickListener { view, pos -> })
        builder.setNegativeButton(
            "NO",
            DialogInterface.OnClickListener { view, pos -> })
        builder.setNeutralButton(
            "CANCEL",
            DialogInterface.OnClickListener { view, pos -> })

        // poner una vista setView

        // 2-> crea el cuadro de dialogo
        return builder.create()
    }
}