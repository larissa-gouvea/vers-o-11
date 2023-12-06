package com.example.clinicaveterinaria.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clinicaveterinaria.CadastroPetActivity
import com.example.clinicaveterinaria.LoginActivity
import com.example.clinicaveterinaria.adapter.PetAdapter
import com.example.clinicaveterinaria.database.PetDAO
import com.example.clinicaveterinaria.databinding.FragmentPetBinding
import com.example.clinicaveterinaria.model.Pet

class PetFragment : Fragment() {

    private lateinit var binding: FragmentPetBinding
    private var listaPets = emptyList<Pet>()
    private var petAdapter: PetAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(layoutInflater)
        val view = binding.root

        binding.fpetFBtnAdicionar.setOnClickListener {
            val intent = Intent(view.context, CadastroPetActivity::class.java );
            startActivity(intent);
        }

        //recyclerView
        petAdapter = PetAdapter()
        binding.recyclerPet.adapter = petAdapter
        binding.recyclerPet.layoutManager = GridLayoutManager(
            view.context, 2
        )
        return view
    }

    private fun atualizarListaPet(){
        val petDao = PetDAO(requireContext())
        listaPets = petDao.listar()
        petAdapter?.adicionarLista(listaPets)
    }

    override fun onStart() {
        super.onStart()
        atualizarListaPet()
    }

}