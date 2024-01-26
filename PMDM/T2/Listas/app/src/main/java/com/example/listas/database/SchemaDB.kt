package com.example.listas.database

interface SchemaDB {

    companion object{
        val DB_NAME: String = "concesionario";
        val TAB_NAME: String = "coche";
        val COL_ID: String = "id";
        val COL_NAME: String = "nombre";
        val COL_MAR: String = "marca";
        val COL_CV: String = "cv";
        val COL_PRE: String = "precio";
        val COL_IMG: String = "imagen";
    }

}