package com.example.mantenedores.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mantenedores.databinding.ActivityMenuMantenedoresBinding


class MenuMantenedores : Fragment() {

    private var _binding: ActivityMenuMantenedoresBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMenuMantenedoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClientes.setOnClickListener {
            val action = MenuMantenedoresDirections.actionMenuMantenedoresToMantenedorCliente(null)
            findNavController().navigate(action)
        }
        binding.btnEmpleados.setOnClickListener {
            val accion = MenuMantenedoresDirections.actionMenuMantenedoresToMantenedorEmpleado(null)
            findNavController().navigate(accion)
        }
        binding.btnProductos.setOnClickListener {
            val accion = MenuMantenedoresDirections.actionMenuMantenedoresToMantenedorProducto(null)
            findNavController().navigate(accion)
        }
        binding.btnProveedor.setOnClickListener {
            val accion = MenuMantenedoresDirections.actionMenuMantenedoresToMantenedorProveedor(null)
            findNavController().navigate(accion)

        }

        binding.btnReportes.setOnClickListener {
            val accion = MenuMantenedoresDirections.actionMenuMantenedoresToSeccionReporte(null)
            findNavController().navigate(accion)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}