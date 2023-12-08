package com.example.mantenedores.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mantenedores.databinding.ActivityMantenedorEmpleadoBinding
import com.example.mantenedores.databinding.ActivityMantenedorProductoBinding
import com.example.mantenedores.entity.Empleado
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.ui.viewmodel.EmpleadoViewModel
import com.example.mantenedores.entity.data.ProductoJSON
import com.example.mantenedores.ui.Application
import com.example.mantenedores.ui.viewmodel.*


class MantenedorEmpleado : Fragment() {

    private var _binding: ActivityMantenedorEmpleadoBinding? = null
    private val binding get() = _binding!!

    private val pViewModel : EmpleadoViewModel by activityViewModels {
        ViewModelFactory1()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMantenedorEmpleadoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGrabar.setOnClickListener {
            val codigo = binding.txtCodigo.text.toString().toInt()
            val nombre = binding.txtNom.text.toString()
            val apellido = binding.txtApellido.text.toString()
            val puesto = binding.txtPuesto.text.toString().toInt()
            val empleado  = EmpleadoJSON(codigo,nombre,apellido,puesto)
            val resultado = pViewModel.registrarEmpleado(empleado)
            println(resultado.toString())
        }

        binding.btnModificar.setOnClickListener {
            val codigo = binding.txtCodigo.text.toString().toInt()
            val nombre = binding.txtNom.text.toString()
            val apellido = binding.txtApellido.text.toString()
            val puesto = binding.txtPuesto.text.toString().toInt()
            val empleado  = EmpleadoJSON(codigo, nombre, apellido
                ,puesto)
            val resultado = pViewModel.actualizarEmpleado(empleado)
            println(resultado.toString())

        }

        binding.btnEliminar.setOnClickListener {
            val codigo = binding.txtCodigo.text.toString().toInt()
            val empleado  = EmpleadoJSON(codigo, null, null
                ,null)
            val resultado = pViewModel.eliminarEmpleado(empleado)
            println(resultado.toString())

        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}