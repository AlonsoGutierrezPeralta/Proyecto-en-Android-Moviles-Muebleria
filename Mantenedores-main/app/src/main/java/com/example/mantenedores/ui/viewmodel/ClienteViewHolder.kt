package com.example.mantenedores.ui.viewmodel

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mantenedores.databinding.ItemClienteBinding
import com.example.mantenedores.entity.data.ClienteJSON

class ClienteViewHolder (private val binding: ItemClienteBinding): ViewHolder(binding.root) {

    fun bind(cliente: ClienteJSON){
        binding.lblRuc.text = cliente.nombre
        binding.lblRazon.text = cliente.apellido
        binding.lblCodigo.text = cliente.codCli.toString()
    }




}