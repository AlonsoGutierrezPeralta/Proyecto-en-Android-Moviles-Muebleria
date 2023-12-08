package com.example.mantenedores.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mantenedores.databinding.ActivityMenuConsultasBinding

class MenuConsultas : Fragment() {
    private var _binding: ActivityMenuConsultasBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMenuConsultasBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClientesCon.setOnClickListener {
            val action = MenuConsultasDirections.actionMenuConsultasToConsultasCliente()
            findNavController().navigate(action)
        }
        binding.btnEmpleadosCon.setOnClickListener {
            val accion = MenuConsultasDirections.actionMenuConsultasToConsultasEmpleados()
            findNavController().navigate(accion)
        }
        binding.btnProductosCon.setOnClickListener {
            val accion = MenuConsultasDirections.actionMenuConsultasToConsultasProductos()
            findNavController().navigate(accion)
        }
        binding.btnProveedorCon.setOnClickListener {
            val accion = MenuConsultasDirections.actionMenuConsultasToConsultasProveedores()
            findNavController().navigate(accion)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}