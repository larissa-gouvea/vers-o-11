package com.example.clinicaveterinaria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.clinicaveterinaria.databinding.ItemListaCardpetBinding
import com.example.clinicaveterinaria.model.Pet

class PetAdapter() : Adapter<PetAdapter.PetViewHolder>(){

    private var listaPet: List<Pet> = emptyList()
    fun adicionarLista(lista:List<Pet>){
        this.listaPet = lista
        notifyDataSetChanged()
    }

    inner class PetViewHolder(itemListaCardpetBinding: ItemListaCardpetBinding)
        :ViewHolder(itemListaCardpetBinding.root){

        private val binding: ItemListaCardpetBinding
        init {
            binding = itemListaCardpetBinding
        }
        fun bind(pet: Pet){
            binding.ilcardpetTxtvNome.text = pet.nome
            binding.ilcardpetTxtvRaca.text = pet.raca
            binding.ilcardpetTxtvDtnasc.text = pet.dt_nasc
            binding.ilcardpetTxtvPeso.text = pet.peso
        }
    }

    //efetua a criação dos itens de lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemListaCardpetBinding = ItemListaCardpetBinding.inflate(
            layoutInflater, parent, false
        )
        return PetViewHolder(itemListaCardpetBinding)
    }

    //efetua a vinculação dos dados a lista do recycler veiw
    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        var pet = listaPet[position]
        holder.bind(pet)
    }

    //retorna quantidade de itens da lista
    override fun getItemCount(): Int {
        return listaPet.size
    }

}