package com.example.mantenedores.ui.viewmodel

import androidx.recyclerview.widget.RecyclerView
import com.example.mantenedores.databinding.ItemEmpleadoBinding
import com.example.mantenedores.entity.Empleado
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.entity.data.ProveedorJSON

class EmpleadosViewHolder (private val binding: ItemEmpleadoBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(empleado: EmpleadoJSON){
        binding.lblCodigo.text = empleado.codigoEmpleado.toString()
        binding.lblNombre.text = empleado.nombre
        binding.lblApellido.text = empleado.apellido

    }
}