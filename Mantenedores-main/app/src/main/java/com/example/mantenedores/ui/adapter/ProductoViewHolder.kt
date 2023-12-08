package com.example.mantenedores.ui.adapter

import android.view.View
import android.widget.NumberPicker
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mantenedores.databinding.FragmentTransaccionBinding
import com.example.mantenedores.databinding.ItemProductoBinding
import com.example.mantenedores.entity.Producto
import com.example.mantenedores.entity.Transaccion
import com.google.android.material.snackbar.Snackbar

class ProductoViewHolder(private val binding: ItemProductoBinding,private val selectedItems: MutableList<Transaccion>) : ViewHolder(binding.root)
{

    fun bind(producto : Producto)
    {
        binding.lblTitulo.text =producto.nombre
        binding.lblPrecio.text = producto.precio.toString()
        binding.lblCantidad.text = "0"
        binding.btnAumentar.setOnClickListener {
            var cantidad = binding.lblCantidad.text.toString().toInt() // Obtén la referencia al NumberPicker desde tu diseño XML
            if(cantidad >= 3)
            {
                val snackbar = Snackbar.make(it, "Límite de Stock por persona", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
            else
            {
                binding.lblCantidad.text = (cantidad + 1).toString()
            }
            println("Click en aumentar")
        }

        binding.btnReducir.setOnClickListener {

            var cantidad = binding.lblCantidad.text.toString().toInt() // Obtén la referencia al NumberPicker desde tu diseño XML
            if(cantidad == 0)
            {
                val snackbar = Snackbar.make(it, "No se puede menor a 0", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
            else
            {
                binding.lblCantidad.text = (cantidad - 1).toString()
            }

            println("Click en aumentar")
        }

        binding.btnAgregar.setOnClickListener {
            val cantidad = binding.lblCantidad.text.toString().toInt()
            if(cantidad == 0)
            {
                val snackbar = Snackbar.make(it, "No puede agregar un producto con 0 de Stock", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
            else
            {
                //Agregar aqui la logica
                val transaccion = Transaccion(producto, cantidad)
                selectedItems.add(transaccion)
                binding.btnAgregar.isEnabled = false
                binding.btnAgregar.text = "Agregado"
                val snackbar = Snackbar.make(it, "Producto: " + producto.nombre + " agregado", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }


        }


    }
}