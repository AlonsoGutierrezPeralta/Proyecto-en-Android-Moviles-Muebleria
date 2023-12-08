package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mantenedores.databinding.ItemCarritoComprasBinding
import com.example.mantenedores.databinding.ItemCompraExitoBinding
import com.example.mantenedores.entity.Transaccion
import com.example.mantenedores.ui.viewmodel.CarritoComprasViewHolder
import com.example.mantenedores.ui.viewmodel.CompraExitoViewHolder

class CompraExitoAdapter(val lista : List<Transaccion>, val onclick: (Transaccion) -> Unit) : Adapter<CompraExitoViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompraExitoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCompraExitoBinding.inflate(inflater, parent, false)
        return CompraExitoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: CompraExitoViewHolder, position: Int)
    {
        val transaccion : Transaccion = lista[position]
        holder.bind(transaccion)
    }

}