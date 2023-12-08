package com.example.mantenedores.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mantenedores.databinding.FragmentCarritoComprasBinding
import com.example.mantenedores.entity.ListaTransaccion
import com.example.mantenedores.entity.data.BoletaJSON
import com.example.mantenedores.entity.data.DetalleBoletaJSON
import com.example.mantenedores.entity.data.ResultadoBoletaJSON
import com.example.mantenedores.ui.adapter.CarritoComprasAdapter
import com.example.mantenedores.ui.adapter.ProductoAdapter
import com.example.mantenedores.ui.viewmodel.ProductoViewModel
import com.example.mantenedores.ui.viewmodel.TransaccionViewModel
import com.example.mantenedores.ui.viewmodel.TransaccionViewModelFactory
import com.example.mantenedores.ui.viewmodel.ViewModelFactory3
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*


class CarritoComprasFragment : Fragment() {

    private var _binding: FragmentCarritoComprasBinding? = null
    private val binding get() = _binding!!

    private val arguments : CarritoComprasFragmentArgs by navArgs()

    private val pViewModel : TransaccionViewModel by activityViewModels {
        TransaccionViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCarritoComprasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        binding.lblFecha.text = "Fecha Ingreso : ${formattedDate}"
        val lstTransaccion : ListaTransaccion? = arguments.lstTransaccion

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvListaProductos.layoutManager = layoutManager

        binding.rvListaProductos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvListaProductos.adapter = CarritoComprasAdapter(lstTransaccion!!.lstTransaccion){}

        binding.btnFinalizar.setOnClickListener {
            val carriAdapter : CarritoComprasAdapter = binding.rvListaProductos.adapter as CarritoComprasAdapter
            val listTransaccion = ListaTransaccion(carriAdapter.obtenerListado(), "008")
            if(listTransaccion == null || carriAdapter.obtenerListado().isEmpty())
            {
                val snackbar = Snackbar.make(view, "No hay productos para realizar la compra", Snackbar.LENGTH_LONG)
                snackbar.show()
                findNavController().navigateUp()
            }
            else
            {
                var lstBoleta : MutableList<DetalleBoletaJSON> = mutableListOf()
                for (transaccion in listTransaccion.lstTransaccion)
                {
                    var detalle = DetalleBoletaJSON(transaccion.producto!!.id.toString(),transaccion.cantidad!!, transaccion.producto.precio!!)
                    lstBoleta.add(detalle)
                }
                //Armar Envio
                val boletaJSON = BoletaJSON("202201", lstBoleta)
                //pViewModel.realizarCompra(boletaJSON)
                pViewModel.realizarCompra(boletaJSON)
                pViewModel.resultado.observe(viewLifecycleOwner)
                {
                        resultado ->
                    when(resultado)
                    {
                        is ResultadoBoletaJSON ->{
                            lstTransaccion.numeroBoleta = resultado.numeroBoleta
                            val accion =CarritoComprasFragmentDirections.actionCarritoComprasFragmentToCompraExitoFragment(lstTransaccion)
                            findNavController().navigate(accion)
                        }
                    }
                }
            }

        }
    }
}