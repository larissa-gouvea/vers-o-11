package com.example.clinicaveterinaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.clinicaveterinaria.database.PetDAO
import com.example.clinicaveterinaria.databinding.ActivityCadastroPetBinding
import com.example.clinicaveterinaria.model.Pet

class CadastroPetActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCadastroPetBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //implementar codigo aqui

        binding.cadPetBtnAcao.setOnClickListener {
            val petDao = PetDAO(this)
            val pet = Pet(
                -1,
                binding.cadPetETxtNome.text.toString(),
                binding.cadPetETxtRaca.text.toString(),
                binding.cadPetETxtPeso.text.toString(),
                binding.cadPetETxtDtNasc.text.toString(),
                -1
            )
            if (petDao.salvar(pet)) {
                Log.i("petdao","Pet ${pet.nome} salvo com sucesso.")
                finish()
            } else {
                Log.i("database","Erro ao salver ${pet.nome}.")
            }
        }
    }
}