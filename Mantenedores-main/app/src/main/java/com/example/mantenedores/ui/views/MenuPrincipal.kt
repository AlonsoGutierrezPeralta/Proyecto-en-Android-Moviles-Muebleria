package com.example.mantenedores.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mantenedores.R
import com.example.mantenedores.databinding.ActivityMenuPrincipalBinding

class MenuPrincipal : Fragment() {

    private var _binding: ActivityMenuPrincipalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMenuPrincipalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMantenedores.setOnClickListener {
            val action = MenuPrincipalDirections.actionMenuPrincipalToMenuMantenedores()
            findNavController().navigate(action)
        }
        binding.btnConsultas.setOnClickListener {
            val action = MenuPrincipalDirections.actionMenuPrincipalToMenuConsultas()
            findNavController().navigate(action)
        }
        binding.btnReporte.setOnClickListener {
            val accion = MenuPrincipalDirections.actionMenuPrincipalToSeccionReporte(null)
            findNavController().navigate(accion)
        }
        binding.btnTransaccion.setOnClickListener {
            val accion = MenuPrincipalDirections.actionMenuPrincipalToTransaccionFragment()
            findNavController().navigate(accion)
        }
    }


    }