package com.example.mantenedores.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.mantenedores.R

class SeccionReporte : Fragment(R.layout.activity_seccion_reporte) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIrMenu = requireView().findViewById<Button>(R.id.btnVolver)

        btnIrMenu.setOnClickListener {
            findNavController().navigate(R.id.action_seccionReporte_to_menuMantenedores)
        }
    }

}