package com.example.mantenedores.ui.views

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mantenedores.databinding.FragmentTransaccionBinding
import com.example.mantenedores.entity.ListaTransaccion
import com.example.mantenedores.entity.Producto
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.ui.adapter.ProductoAdapter
import com.example.mantenedores.ui.viewmodel.ProductoViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory
import com.example.mantenedores.ui.viewmodel.ViewModelFactory3
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration

class TransaccionFragment : Fragment() {

    private var _binding: FragmentTransaccionBinding? = null
    private val binding get() = _binding!!

    private val pViewModel : ProductoViewModel by activityViewModels {
        ViewModelFactory3()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTransaccionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pViewModel.listarProductos()
        pViewModel.listadoProductos.observe(viewLifecycleOwner)
        {
            resultado ->
                when(resultado)
                {
                    is ResultJSON.Exito ->{
                        val lista = resultado.data
                        val listadoProducto : MutableList<Producto> = mutableListOf()
                        for (producto in lista)
                        {
                            var pro = Producto(producto.codigoProducto!!.toInt(),
                                producto.codigoProveedor.toString(),
                                producto.descripcion,
                                producto.tipo.toString(),
                                producto.stock.toString(),
                                producto.precio)
                            listadoProducto.add(pro)
                        }
                        println(listadoProducto)
                        val layoutManager = LinearLayoutManager(requireContext())
                        binding.rvProductos.layoutManager = GridLayoutManager(requireContext(), 2)
                        binding.rvProductos.adapter = ProductoAdapter(listadoProducto){}
                        val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)

                        val metric = resources.displayMetrics

                        divider.dividerInsetStart = (8f * metric.density).toInt()
                        divider.dividerInsetEnd = (8f * metric.density).toInt()

                        divider.isLastItemDecorated = false

                        binding.rvProductos.addItemDecoration(divider)
                    }
                    is ResultJSON.Problema-> {
                        MaterialAlertDialogBuilder(requireContext())
                            .setTitle("Error")
                            .setMessage(resultado.error.exito)
                            .setPositiveButton("Aceptar", null)
                            .show()
                    }
                }

        }





        //Agregar la logica de subida de
        binding.btnSiguiente.setOnClickListener {
            val prodAdapter : ProductoAdapter = binding.rvProductos.adapter as ProductoAdapter
            println(prodAdapter.obtenerTodosProductos())
            val listTransaccion = ListaTransaccion(prodAdapter.obtenerTodosProductos(),"-25")
            val accion =TransaccionFragmentDirections.actionTransaccionFragmentToCarritoComprasFragment(listTransaccion)
            findNavController().navigate(accion)
        }


    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}