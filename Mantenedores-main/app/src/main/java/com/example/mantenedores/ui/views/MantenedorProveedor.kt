package com.example.mantenedores.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mantenedores.databinding.ActivityMantenedorProductoBinding
import com.example.mantenedores.databinding.ActivityMantenedorProveedorBinding
import com.example.mantenedores.entity.Producto
import com.example.mantenedores.entity.Proveedor
import com.example.mantenedores.entity.data.ProductoJSON
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.ui.Application
import com.example.mantenedores.ui.viewmodel.*


class MantenedorProveedor : Fragment() {

    private var _binding: ActivityMantenedorProveedorBinding? = null
    private val binding get() = _binding!!

    private val pViewModel : ProveedorViewModel by activityViewModels {
        ViewModelFactory2()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMantenedorProveedorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGrabar.setOnClickListener {
            val raz = binding.txtRazon.text.toString()
            val ruc = binding.txtRuc.text.toString().toInt()
            val cod = binding.txtCodigoProv.text.toString().toInt()
            val proveedor  = ProveedorJSON( raz, ruc
                ,cod)
            val resultado = pViewModel.registrarProveedor(proveedor)
            println(resultado.toString())
        }

        binding.btnModificar.setOnClickListener {
            val raz = binding.txtRazon.text.toString()
            val ruc = binding.txtRuc.text.toString().toInt()
            val cod = binding.txtCodigoProv.text.toString().toInt()
            val proveedor  = ProveedorJSON( raz, ruc
                ,cod)
            val resultado = pViewModel.actualizarProveedor(proveedor)
            println(resultado.toString())

        }

        binding.btnEliminar.setOnClickListener {
            val cod = binding.txtCodigoProv.text.toString().toInt()
            val proveedor  = ProveedorJSON(null, null, cod
                )
            val resultado = pViewModel.eliminarProveedor(proveedor)
            println(resultado.toString())

        }



    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}