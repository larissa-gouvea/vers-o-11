package com.example.clinicaveterinaria.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper (context : Context): SQLiteOpenHelper(
    //-> contexto       -> nome database
    //-> CursorFactory  -> versão database
    context, "clinicaVet", null, 1
) {

    companion object{
        const val NOME_BANCO = "clinicaVet"



        const val TABELA_INGREDIENTE = "VetTable"
        const val TINGREDIENTE_CODIGO = "codigo"
        const val TINGREDIENTE_NOME = "nome"
        const val TINGREDIENTE_QUANTIDADE = "especialidade"

        const val TABELA_RECEITA = "ReceitaTable"
        const val TRECEITA_CODIGO = "codigo"
        const val TRECEITA_NOME = "nome"




        const val TABELA_PET = "PetTable"
        const val TPET_CODIGO = "cod"
        const val TPET_NOME = "nome"
        const val TPET_RACA = "raca"
        const val TPET_PESO = "peso"
        const val TPET_DTNASC = "data_nasc"
        const val TPET_CODRESP = "cod_resp"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        Log.i("database", "Entrou em databasehelper")




        val sqlvet = "CREATE TABLE ${DatabaseHelper.TABELA_INGREDIENTE} ("+
                "${DatabaseHelper.TINGREDIENTE_CODIGO} integer PRIMARY KEY AUTOINCREMENT,"+
                "${DatabaseHelper.TINGREDIENTE_NOME} varchar(100) NOT NULL,"+
                "${DatabaseHelper.TINGREDIENTE_QUANTIDADE} varchar(50) NOT NULL);"

        try {
            db?.execSQL(sqlvet)
            Log.i("db", "Sucesso ao criar a tabela ${DatabaseHelper.TABELA_INGREDIENTE}.")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("db", "Erro ao criar a tabela ${DatabaseHelper.TABELA_INGREDIENTE}.")
        }


        val sqlreceita = "CREATE TABLE ${DatabaseHelper.TABELA_RECEITA} ("+
                "${DatabaseHelper.TRECEITA_CODIGO} integer PRIMARY KEY AUTOINCREMENT,"+
                "${DatabaseHelper.TRECEITA_NOME} varchar(100) NOT NULL);"

        try {
            db?.execSQL(sqlreceita)
            Log.i("db", "Sucesso ao criar a tabela ${DatabaseHelper.TABELA_RECEITA}.")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("db", "Erro ao criar a tabela ${DatabaseHelper.TABELA_RECEITA}.")
        }



        val sql = "CREATE TABLE PetTable (" +
                "    cod integer PRIMARY KEY AUTOINCREMENT," +
                "    nome varchar(100) NOT NULL," +
                "    raca varchar(50) NOT NULL," +
                "    peso decimal(5,2) NOT NULL," +
                "    data_nasc varchar(10)," +
                "    cod_resp integer"+
                ");"

        try {
            db?.execSQL( sql )
            Log.i("database", "Sucesso ao criar a tabela")
        }catch (e: Exception){
            e.printStackTrace()
            Log.i("database", "Erro ao criar a tabela")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}