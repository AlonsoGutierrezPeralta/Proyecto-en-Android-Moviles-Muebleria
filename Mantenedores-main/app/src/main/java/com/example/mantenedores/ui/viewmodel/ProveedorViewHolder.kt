package com.example.mantenedores.ui.viewmodel

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mantenedores.databinding.ItemProveedorBinding
import com.example.mantenedores.entity.Proveedor
import com.example.mantenedores.entity.data.ProveedorJSON

class ProveedorViewHolder (private val binding: ItemProveedorBinding) : ViewHolder(binding.root) {

    fun bind(proveedor: ProveedorJSON){
        binding.lblRazon.text = proveedor.razSocial
        binding.lblRuc.text = proveedor.ruc.toString()
        binding.lblCodigo.text = proveedor.codProv.toString()
    }

}