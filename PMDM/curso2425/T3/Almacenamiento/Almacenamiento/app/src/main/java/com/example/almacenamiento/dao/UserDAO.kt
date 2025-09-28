package com.example.almacenamiento.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.almacenamiento.database.DBHelper
import com.example.almacenamiento.model.User

class UserDAO(var context: Context) {

    fun insertUser(user: User) {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase
        // INSERT INTO asdasd () VALUES (asdas,asd,asd,asd,asd)
        // database.execSQL()
        val content: ContentValues = ContentValues();
        content.put("name", user.name)
        content.put("age", user.age)
        database.insert("user", null, content)
    }

    fun deleteUser(name: String) {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase
        // SELETE FROM asdasd WHERE asdasd=?
        // database.execSQL()
        database.delete("user", "name=?", arrayOf(name))
    }

    fun updateUser(name: String) {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).writableDatabase
        // SELETE FROM asdasd WHERE asdasd=?
        // database.execSQL()
        val content = ContentValues()
        content.put("name", "NombreNuevo")
        // UPDATE user SET nombre=NombreNuevo WHERE name=Borja
        database.update("user", content, "name=?", arrayOf(name))
    }

    fun getUsers(): Int {
        val database: SQLiteDatabase = DBHelper(context, "users_db", null, 1).readableDatabase
        val cursor: Cursor =
            database.query("user", arrayOf("id","name", "age"), null, null, null, null, null)
        var contador = 0
        while (cursor.moveToNext()){
            contador++
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            Log.v("database_users", "ID: ${id.toString()} Name: $name Age: $age")
        }

        return contador
    }

}