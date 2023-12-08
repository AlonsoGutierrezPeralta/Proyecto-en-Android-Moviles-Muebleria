package com.example.mantenedores.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mantenedores.databinding.ActivityConsultasProveedoresBinding
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.ui.adapter.ProveedorAdapter
import com.example.mantenedores.ui.viewmodel.ProveedorViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration


class ConsultasProveedores : Fragment() {
    private var _binding: ActivityConsultasProveedoresBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProveedorViewModel by activityViewModels {
        ViewModelFactory2()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityConsultasProveedoresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listarProveedor()
        viewModel.listadoProveedor.observe(viewLifecycleOwner){resultado ->
            when(resultado){
                is ResultJSON.Exito ->{
                    val lista = resultado.data

                    val adapter = ProveedorAdapter(lista)
                    binding.rvProveedores.adapter = adapter
                    binding.rvProveedores.layoutManager = LinearLayoutManager(requireContext())

                    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
                    val metric = resources.displayMetrics

                    divider.dividerInsetStart = (20f * metric.density).toInt()
                    divider.dividerInsetEnd = (20f * metric.density).toInt()

                    binding.rvProveedores.addItemDecoration(divider)

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