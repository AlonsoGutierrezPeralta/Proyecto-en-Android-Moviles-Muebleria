package com.example.mantenedores.ui.viewmodel

import androidx.recyclerview.widget.RecyclerView
import com.example.mantenedores.databinding.ItemProductosBinding
import com.example.mantenedores.databinding.ItemProveedorBinding
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.entity.data.ProductoJSON

class ProductosViewHolder (private val binding: ItemProductosBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(productos: ProductoJSON){
        binding.lblCodigo.text = productos.codigoProducto.toString()
        binding.lblDespro.text = productos.descripcion
        binding.lblStockpro.text = productos.stock.toString()
        binding.lblPreciopro.text = productos.precio.toString()
    }
}