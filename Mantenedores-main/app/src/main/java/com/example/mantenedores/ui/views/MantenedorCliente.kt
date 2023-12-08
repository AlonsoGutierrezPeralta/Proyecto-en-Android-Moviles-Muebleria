package com.example.mantenedores.ui.views
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mantenedores.databinding.ActivityMantenedorClienteBinding
import com.example.mantenedores.databinding.ActivityMantenedorProveedorBinding
import com.example.mantenedores.entity.Cliente
import com.example.mantenedores.entity.data.ClienteJSON
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.ui.Application
import com.example.mantenedores.ui.viewmodel.ClienteViewModel
import com.example.mantenedores.ui.viewmodel.ProveedorViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory
import com.example.mantenedores.ui.viewmodel.ViewModelFactory2


class MantenedorCliente : Fragment() {

    private var _binding: ActivityMantenedorClienteBinding? = null
    private val binding get() = _binding!!

    private val pViewModel : ClienteViewModel by activityViewModels {
        ViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMantenedorClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGrabar.setOnClickListener {
            val nom = binding.txtNombre.text.toString()
            val ape = binding.txtApellidos.text.toString()
            val cod = binding.txtCodigo.text.toString().toInt()
            val cliente  = ClienteJSON( nom, ape,cod)
            val resultado = pViewModel.registrarCliente(cliente)
            println(resultado.toString())
        }

        binding.btnModificar.setOnClickListener {
            val nom = binding.txtNombre.text.toString()
            val ape = binding.txtApellidos.text.toString()
            val cod = binding.txtCodigo.text.toString().toInt()
            val cliente  = ClienteJSON( nom, ape,cod)
            val resultado = pViewModel.actualizarCliente(cliente)
            println(resultado.toString())

        }

        binding.btnEliminar.setOnClickListener {
            val cod = binding.txtCodigo.text.toString().toInt()
            val cliente  = ClienteJSON(null, null, cod
            )
            val resultado = pViewModel.eliminarCliente(cliente)
            println(resultado.toString())

        }



    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
