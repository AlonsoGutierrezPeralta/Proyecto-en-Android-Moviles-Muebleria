package com.example.mantenedores.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mantenedores.R
import com.example.mantenedores.databinding.ActivityConsultasClienteBinding
import com.example.mantenedores.databinding.ActivityConsultasEmpleadosBinding
import com.example.mantenedores.databinding.ActivityConsultasProveedoresBinding
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.ui.adapter.EmpleadoAdapter
import com.example.mantenedores.ui.adapter.ProveedorAdapter
import com.example.mantenedores.ui.viewmodel.EmpleadoViewModel
import com.example.mantenedores.ui.viewmodel.ProveedorViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory1
import com.example.mantenedores.ui.viewmodel.ViewModelFactory2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration

class ConsultasEmpleados : Fragment() {
    private var _binding: ActivityConsultasEmpleadosBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EmpleadoViewModel by activityViewModels {
        ViewModelFactory1()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityConsultasEmpleadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listarEmpleado()
        viewModel.listadoEmpleado.observe(viewLifecycleOwner){resultado ->
            when(resultado){
                is ResultJSON.Exito ->{
                    val lista = resultado.data
                    println(lista)
                    val adapter = EmpleadoAdapter(lista)
                    binding.rvEmpleados.adapter = adapter
                    binding.rvEmpleados.layoutManager = LinearLayoutManager(requireContext())

                    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
                    val metric = resources.displayMetrics

                    divider.dividerInsetStart = (20f * metric.density).toInt()
                    divider.dividerInsetEnd = (20f * metric.density).toInt()

                    binding.rvEmpleados.addItemDecoration(divider)

                }
                is ResultJSON.Problema ->{
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Error")
                        .setMessage(resultado.error.exito)
                        .setPositiveButton("Aceptar", null)
                        .show()
                }
            }
        }



    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}