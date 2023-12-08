package com.example.mantenedores.ui.viewmodel

import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mantenedores.databinding.ItemCarritoComprasBinding
import com.example.mantenedores.entity.Transaccion
import com.google.android.material.snackbar.Snackbar


class CarritoComprasViewHolder(private val binding : ItemCarritoComprasBinding, private var lista: List<Transaccion>) : ViewHolder(binding.root) {

    private val lstTransaccion : MutableList<Transaccion> = lista as MutableList<Transaccion>

    fun bind(transaccion : Transaccion)
    {
        binding.lblNombreProducto.text = transaccion.producto!!.nombre
        binding.lblCodigoProducto.text = transaccion.producto!!.id.toString()
        binding.lblCantidadTransaccion.text = transaccion.cantidad.toString()

        binding.btnQuitar.setOnClickListener {

            val iterator = lstTransaccion.iterator()
            val codigo = binding.lblCodigoProducto.text.toString().toInt()
            while (iterator.hasNext()) {
                val transaccion = iterator.next()
                if (codigo == transaccion.producto!!.id) {
                    println("-----------Se elimno: $transaccion")
                    iterator.remove()
                }

            }
            val parentLayout = itemView.parent as ViewGroup
            parentLayout.removeView(itemView)
            //Aqui quiero remover el linear layout
        }
        println("-------------Resutlado $lstTransaccion")
        lista = lstTransaccion
    }


}