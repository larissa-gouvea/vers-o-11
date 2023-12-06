package com.example.clinicaveterinaria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.example.clinicaveterinaria.databinding.ItemListaIngredienteBinding
import com.example.clinicaveterinaria.model.Ingrediente

class IngredienteAdapter(
    val onClickExcluir: (Int) -> Unit,
    val onClickEditar: (Ingrediente) -> Unit
) : Adapter<IngredienteAdapter.VetViewHolder>() {

    private var listaIngrediente: List<Ingrediente> = emptyList()
    fun adicionarLista(lista:List<Ingrediente>){
        this.listaIngrediente = lista
        notifyDataSetChanged()
    }

    inner class VetViewHolder(itemListaIngredienteBinding: ItemListaIngredienteBinding)
        : ViewHolder(itemListaIngredienteBinding.root){

        private val binding: ItemListaIngredienteBinding
        init {
            binding = itemListaIngredienteBinding
        }

        fun bind(ingrediente: Ingrediente){
            binding.itvetTxtvNome.text = ingrediente.nome
            binding.itvetTxtvEspecial.text = ingrediente.quantidade


            binding.ibtnDeletarVet.setOnClickListener {
                onClickExcluir(ingrediente.codigo)
            }
            binding.ibtnEditarVet.setOnClickListener {
                onClickEditar(ingrediente)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VetViewHolder {
        val layoutInflater = LayoutInflater.from(
            parent.context
        )
        val itemListaIngredienteBinding = ItemListaIngredienteBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return VetViewHolder(itemListaIngredienteBinding)
    }

    override fun onBindViewHolder(holder: VetViewHolder, position: Int) {
        var vet = listaIngrediente[position]
        holder.bind(vet)
    }

    override fun getItemCount(): Int {
        return listaIngrediente.size
    }

}
