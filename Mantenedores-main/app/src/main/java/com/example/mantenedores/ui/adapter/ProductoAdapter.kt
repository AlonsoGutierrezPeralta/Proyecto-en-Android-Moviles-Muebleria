package com.example.mantenedores.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mantenedores.databinding.FragmentTransaccionBinding
import com.example.mantenedores.databinding.ItemProductoBinding
import com.example.mantenedores.entity.Producto
import com.example.mantenedores.entity.Transaccion

class ProductoAdapter(val lista : List<Producto>, val onclick: (Producto) -> Unit) : Adapter<ProductoViewHolder>() {

    private val lstTransaccion = mutableListOf<Transaccion>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductoBinding.inflate(inflater, parent, false)
        return ProductoViewHolder(binding, lstTransaccion)
    }



    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = lista[position]
        holder.bind(producto)

    }

    fun obtenerTodosProductos(): List<Transaccion> {
        return lstTransaccion
    }
}