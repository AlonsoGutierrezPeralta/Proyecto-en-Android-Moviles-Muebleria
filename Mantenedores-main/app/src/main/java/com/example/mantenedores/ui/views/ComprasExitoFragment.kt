package com.example.mantenedores.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mantenedores.R
import com.example.mantenedores.databinding.FragmentCarritoComprasBinding
import com.example.mantenedores.databinding.FragmentComprasExitoBinding
import com.example.mantenedores.entity.ListaTransaccion
import com.example.mantenedores.ui.adapter.CarritoComprasAdapter
import com.example.mantenedores.ui.adapter.CompraExitoAdapter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class ComprasExitoFragment : Fragment() {

    private var _binding: FragmentComprasExitoBinding? = null
    private val binding get() = _binding!!

    private val arguments : ComprasExitoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentComprasExitoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        binding.lblFecha.text = "Fecha Ingreso : ${formattedDate}"

        val lstTransaccion : ListaTransaccion? = arguments.lstTransaccion
        binding.lblBoleta.text = "Boleta: " + lstTransaccion!!.numeroBoleta
        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvListaProductos.layoutManager = layoutManager

        binding.rvListaProductos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvListaProductos.adapter = CompraExitoAdapter(lstTransaccion!!.lstTransaccion){}

        binding.btnVolvelMenuPrincipal.setOnClickListener {
            val accion = findNavController()
            accion.popBackStack(accion.graph.startDestinationId, false)
        }

    }
}