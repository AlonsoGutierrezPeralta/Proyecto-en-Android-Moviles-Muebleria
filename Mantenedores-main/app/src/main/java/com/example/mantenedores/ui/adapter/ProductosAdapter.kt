package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mantenedores.databinding.ItemEmpleadoBinding
import com.example.mantenedores.databinding.ItemProductosBinding
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.entity.data.ProductoJSON
import com.example.mantenedores.ui.viewmodel.EmpleadosViewHolder
import com.example.mantenedores.ui.viewmodel.ProductosViewHolder

class ProductosAdapter (val lista: List<ProductoJSON>) : RecyclerView.Adapter<ProductosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val binding = ItemProductosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductosViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val productos = lista[position]
        holder.bind(productos)
    }
}