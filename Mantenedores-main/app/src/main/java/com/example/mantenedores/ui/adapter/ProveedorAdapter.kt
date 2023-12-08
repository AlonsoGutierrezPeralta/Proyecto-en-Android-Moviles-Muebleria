package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mantenedores.databinding.ItemProveedorBinding
import com.example.mantenedores.entity.Proveedor
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.ui.viewmodel.ProveedorViewHolder

class ProveedorAdapter(val lista: List<ProveedorJSON>) : Adapter<ProveedorViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProveedorViewHolder {
        val binding = ItemProveedorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProveedorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ProveedorViewHolder, position: Int) {
        val proveedor = lista[position]
        holder.bind(proveedor)
    }

}