package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mantenedores.databinding.ItemCarritoComprasBinding
import com.example.mantenedores.entity.ListaTransaccion
import com.example.mantenedores.entity.Transaccion
import com.example.mantenedores.ui.viewmodel.CarritoComprasViewHolder

class CarritoComprasAdapter(var lista: List<Transaccion>, val onclick: (Transaccion) -> Unit) :Adapter<CarritoComprasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoComprasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCarritoComprasBinding.inflate(inflater, parent, false)
        return CarritoComprasViewHolder(binding, lista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }


    override fun onBindViewHolder(holder: CarritoComprasViewHolder, position: Int)
    {
        val transaccion : Transaccion = lista[position]
        holder.bind(transaccion)
        
    }
    fun obtenerListado() : List<Transaccion>{
        return lista
    }
}