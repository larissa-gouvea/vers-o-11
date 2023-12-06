package com.example.clinicaveterinaria.database

import com.example.clinicaveterinaria.model.Pet

interface IPetDao {
    fun salvar( pet: Pet ): Boolean
    fun atualizar( pet: Pet ): Boolean
    fun deletar( id: Int ): Boolean
    fun listar(): List<Pet>
}