package com.example.listas.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import com.example.listas.model.Coche

class DBHelper(var contexto: Context, var dbname: String, var version: Int):
    SQLiteOpenHelper(contexto,dbname,null,version) {
    // permite "llegar" a la base de datos

    override fun onCreate(db: SQLiteDatabase?) {
       // crear la base de datos "si no existe"
        db?.execSQL("CREATE TABLE ${SchemaDB.TAB_NAME} (${SchemaDB.COL_ID} INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "${SchemaDB.COL_NAME} TEXT," +
                "${SchemaDB.COL_MAR} TEXT, ${SchemaDB.COL_PRE} INTEGER, " +
                "${SchemaDB.COL_CV} INTEGER, ${SchemaDB.COL_IMG} TEXT  )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // actualizar la base de datos, si la version es superior a la version actual
    }

    // metodos que actuan contra la BD -> CUD

    fun agregarCoche(coche: Coche) {
        val baseDatos = writableDatabase
        // QUERY INSERT into coche (nombre, marca, precio, cv, imagen) VALUES ('123','123',123,'123',123)
        // baseDatos.execSQL()
        // content value
        val contenteValue = ContentValues()
        contenteValue.put(SchemaDB.COL_NAME, coche.nombre)
        contenteValue.put(SchemaDB.COL_MAR, coche.marca)
        contenteValue.put(SchemaDB.COL_CV, coche.cv)
        contenteValue.put(SchemaDB.COL_PRE, coche.precio)
        contenteValue.put(SchemaDB.COL_IMG, coche.imagen)
        baseDatos.insert(SchemaDB.TAB_NAME,null,contenteValue)
    }

    fun getCoches(): ArrayList<Coche>
    {
        val baseDatos= this.readableDatabase
        val query = "SELECT * FROM ${SchemaDB.TAB_NAME}"
        val resultados = baseDatos.rawQuery(query, null);
        val listaResultado = ArrayList<Coche>()

        while (resultados.moveToNext()){
            val posicionNombre = resultados.getColumnIndex(SchemaDB.COL_NAME)
            val nombre = resultados.getString(posicionNombre)
            val posicionMarca = resultados.getColumnIndex(SchemaDB.COL_MAR)
            val marca = resultados.getString(posicionMarca)
            val posicionPrecio = resultados.getColumnIndex(SchemaDB.COL_PRE)
            val precio = resultados.getInt(posicionPrecio)
            val posicionImagen = resultados.getColumnIndex(SchemaDB.COL_IMG)
            val imagen = resultados.getString(posicionImagen)
            val posicionCV = resultados.getColumnIndex(SchemaDB.COL_CV)
            val cv = resultados.getInt(posicionCV)
            listaResultado.add(Coche(nombre,marca,precio, cv, imagen))
        }

        return listaResultado
    }
}