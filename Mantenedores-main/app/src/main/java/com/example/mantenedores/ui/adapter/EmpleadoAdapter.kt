package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mantenedores.databinding.ItemEmpleadoBinding
import com.example.mantenedores.databinding.ItemProveedorBinding
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.ui.viewmodel.EmpleadosViewHolder
import com.example.mantenedores.ui.viewmodel.ProveedorViewHolder

class EmpleadoAdapter (val lista: List<EmpleadoJSON>) : RecyclerView.Adapter<EmpleadosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadosViewHolder {
        val binding = ItemEmpleadoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmpleadosViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: EmpleadosViewHolder, position: Int) {
        val empleado = lista[position]
        holder.bind(empleado)
    }
}