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
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.ui.adapter.ClienteAdapter
import com.example.mantenedores.ui.adapter.ProductosAdapter
import com.example.mantenedores.ui.viewmodel.ClienteViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration

class ConsultasCliente : Fragment() {
    private var _binding: ActivityConsultasClienteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClienteViewModel by activityViewModels {
        ViewModelFactory()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityConsultasClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listarCliente()
        viewModel.listadoCliente.observe(viewLifecycleOwner){resultado ->
            when(resultado){
                is ResultJSON.Exito ->{
                    val lista = resultado.data
                    println(lista)
                    val adapter = ClienteAdapter(lista)
                    binding.rvClientes.adapter = adapter
                    binding.rvClientes.layoutManager = LinearLayoutManager(requireContext())

                    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
                    val metric = resources.displayMetrics

                    divider.dividerInsetStart = (20f * metric.density).toInt()
                    divider.dividerInsetEnd = (20f * metric.density).toInt()

                    binding.rvClientes.addItemDecoration(divider)


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