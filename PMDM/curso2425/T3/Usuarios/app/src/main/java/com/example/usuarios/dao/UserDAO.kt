package com.example.usuarios.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.usuarios.database.DBHelper
import com.example.usuarios.model.User

class UserDAO(var context: Context) {

    // TODAS las acciones contra BD del modelo User

    // CREATE
    fun insertUser(user: User) {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase
        // database.execSQL("INSERT INTO aSDASD () VALUES (asdasd,asdasd)")
        val content = ContentValues()
        content.put("name", user.name)
        content.put("age", user.age)
        database.insert("users", null, content);
    }

    // SELECT
    fun getUsers(): Int {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).readableDatabase;
        var contador: Int = 0;
        // "name = ?"
        val resultado: Cursor = database.query(
            "users", arrayOf("name", "age"),
            null, null,
            null, null,
            null
        )
        //                 v
        // R R R R R R R R R
        // SELECT name, age FROM users
        // [ {borja,59},{juan,54}]
        while (resultado.moveToNext()){
            contador++
            val name = resultado.getString(resultado.getColumnIndexOrThrow("name"))
            val age = resultado.getInt(resultado.getColumnIndexOrThrow("age"))
            Log.v("msg","Name: ${name} Age: $age")
        }
        return contador;
    }
}