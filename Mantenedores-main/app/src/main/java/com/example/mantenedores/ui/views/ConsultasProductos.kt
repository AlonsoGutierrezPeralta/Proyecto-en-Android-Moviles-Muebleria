package com.example.mantenedores.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mantenedores.databinding.ActivityConsultasEmpleadosBinding
import com.example.mantenedores.databinding.ActivityConsultasProductosBinding
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.ui.adapter.EmpleadoAdapter
import com.example.mantenedores.ui.adapter.ProductosAdapter
import com.example.mantenedores.ui.viewmodel.EmpleadoViewModel
import com.example.mantenedores.ui.viewmodel.ProductoViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory2
import com.example.mantenedores.ui.viewmodel.ViewModelFactory3
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration

class ConsultasProductos : Fragment() {
    private var _binding: ActivityConsultasProductosBinding? = null
    private val binding get() = _binding!!


    private val viewModel: ProductoViewModel by activityViewModels {
        ViewModelFactory3()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityConsultasProductosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listarProductos()
        viewModel.listadoProductos.observe(viewLifecycleOwner){resultado ->
            when(resultado){
                is ResultJSON.Exito ->{
                    val lista = resultado.data

                    val adapter =ProductosAdapter(lista)
                    binding.rvProductos.adapter = adapter
                    binding.rvProductos.layoutManager = LinearLayoutManager(requireContext())

                    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
                    val metric = resources.displayMetrics

                    divider.dividerInsetStart = (20f * metric.density).toInt()
                    divider.dividerInsetEnd = (20f * metric.density).toInt()

                    binding.rvProductos.addItemDecoration(divider)

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