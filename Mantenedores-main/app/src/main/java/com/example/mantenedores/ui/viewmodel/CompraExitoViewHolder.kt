package com.example.mantenedores.ui.viewmodel

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mantenedores.databinding.ItemCompraExitoBinding
import com.example.mantenedores.entity.Transaccion

class CompraExitoViewHolder(val binding : ItemCompraExitoBinding) : ViewHolder(binding.root)
{
    fun bind(transaccion : Transaccion)
    {
        binding.lblNombreProducto.text = transaccion.producto!!.nombre
        binding.lblCantidadTransaccion.text = transaccion.cantidad.toString()
        binding.lblCodigoProducto.text = transaccion.producto.id.toString()
    }
}