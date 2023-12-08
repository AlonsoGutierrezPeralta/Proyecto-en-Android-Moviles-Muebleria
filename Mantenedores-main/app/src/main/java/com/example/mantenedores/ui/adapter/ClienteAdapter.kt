package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mantenedores.databinding.ItemClienteBinding
import com.example.mantenedores.entity.data.ClienteJSON
import com.example.mantenedores.ui.viewmodel.ClienteViewHolder

class ClienteAdapter(val lista: List<ClienteJSON>) : Adapter<ClienteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val binding = ItemClienteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClienteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        val cliente = lista[position]
        holder.bind(cliente)
    }


}