package com.example.clinicaveterinaria.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.clinicaveterinaria.model.Pet
import java.util.*
import kotlin.collections.ArrayList

class PetDAO(context: Context) : IPetDao {

    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(pet: Pet): Boolean {
        val valores = ContentValues()
        valores.put("${DatabaseHelper.TPET_NOME}", pet.nome);
        valores.put("${DatabaseHelper.TPET_RACA}", pet.raca);
        valores.put("${DatabaseHelper.TPET_PESO}", pet.peso);
        valores.put("${DatabaseHelper.TPET_DTNASC}", pet.dt_nasc);
        valores.put("${DatabaseHelper.TPET_CODRESP}", -1);
        try {
            escrita.insert(
                DatabaseHelper.TABELA_PET,
                null,
                valores
            )
            Log.i("database", "Pet inserido na tabela. ${DatabaseHelper.TABELA_PET}.")
        } catch (e: Exception) {
            Log.i("database", "Erro ao inserir Pet na tabela ${DatabaseHelper.TABELA_PET}.")
            return false
        }
        return true
    }

    override fun atualizar(pet: Pet): Boolean {

        try {

        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun deletar(id: Int): Boolean {

        try {

        } catch (e: Exception) {
            return false
        }
        return true
    }

    override fun listar(): List<Pet> {
        val listaPets = ArrayList<Pet>()

        val sql = "SELECT * FROM ${DatabaseHelper.TABELA_PET}"
        val cursor = leitura.rawQuery(sql,null)
        //capturando os indices das colunas
        val iCodigo = cursor.getColumnIndex(DatabaseHelper.TPET_CODIGO);
        val iNome = cursor.getColumnIndex(DatabaseHelper.TPET_NOME);
        val iRaca = cursor.getColumnIndex(DatabaseHelper.TPET_RACA);
        val iPeso = cursor.getColumnIndex(DatabaseHelper.TPET_PESO);
        val iDtnasc = cursor.getColumnIndex(DatabaseHelper.TPET_DTNASC);
        val iCodResp = cursor.getColumnIndex(DatabaseHelper.TPET_CODRESP);

        while (cursor.moveToNext()){
            val codPet = cursor.getInt(iCodigo)
            val nome = cursor.getString(iNome)
            val raca = cursor.getString(iRaca)
            val peso = cursor.getString(iPeso)
            val dtNasc = cursor.getString(iCodigo)
            val codResp = cursor.getInt(iCodResp)
            listaPets.add(
                Pet(codPet, nome, raca, peso, dtNasc, codResp)
            )
            Log.i("database","Pet $nome adicionado a lista. \n")
        }
        return listaPets
    }

}