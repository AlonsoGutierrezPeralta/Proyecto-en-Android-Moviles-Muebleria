package com.example.mantenedores.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mantenedores.databinding.ActivityMantenedorProductoBinding
import com.example.mantenedores.entity.Producto
import com.example.mantenedores.entity.data.ProductoJSON
import com.example.mantenedores.ui.Application
import com.example.mantenedores.ui.viewmodel.ProductoViewModel
import com.example.mantenedores.ui.viewmodel.ViewModelFactory
import com.example.mantenedores.ui.viewmodel.ViewModelFactory1
import com.example.mantenedores.ui.viewmodel.ViewModelFactory3


class MantenedorProducto : Fragment() {

    private var _binding: ActivityMantenedorProductoBinding? = null
    private val binding get() = _binding!!

    private val pViewModel : ProductoViewModel by activityViewModels {
        ViewModelFactory3()
    }
    //   private val pViewModel: ProductoViewModel by activityViewModels {
    //       val repository = (requireActivity().application as Application).repository
    //      ViewModelFactory1(repository)
    //  }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ActivityMantenedorProductoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGrabar.setOnClickListener {
            val codigo = binding.txtCodigo.text.toString().toInt()
            val nombre = binding.txtProducto.text.toString()
            val stock = binding.txtStock.text.toString().toInt()
            val precio = binding.txtPrecio.text.toString().toDouble()
            val producto  = ProductoJSON(codigo, 1001, nombre
            ,1,stock,precio)
            val resultado = pViewModel.registrarProducto(producto)
            println(resultado.toString())
        }

        binding.btnModificar.setOnClickListener {
            val codigo = binding.txtCodigo.text.toString().toInt()
            val nombre = binding.txtProducto.text.toString()
            val stock = binding.txtStock.text.toString().toInt()
            val precio = binding.txtPrecio.text.toString().toDouble()
            val producto  = ProductoJSON(codigo, 1001, nombre
                ,1,stock,precio)
            val resultado = pViewModel.actualizarProducto(producto)
            println(resultado.toString())

        }

        binding.btnEliminar.setOnClickListener {
            val codigo = binding.txtCodigo.text.toString().toInt()
            val producto  = ProductoJSON(codigo, null, null
                ,null,null,null)
            val resultado = pViewModel.eliminarProducto(producto)
            println(resultado.toString())

        }



    }


    //   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //       super.onViewCreated(view, savedInstanceState)


//        binding.btnGrabar.setOnClickListener {
    //          val nombres = binding.txtNom.text.toString()
//            val apellido = binding.txtApellido.text.toString()
    //          val puesto = binding.txtPuesto.text.toString()
    //          val nuevoEmpleado = Empleado(0, nombres, apellido, puesto)
    //          pViewModel.insertar(nuevoEmpleado)
    //       }
    //binding.btnNuevo.setOnClickListener {
    //  }

    //       binding.btnEliminar.setOnClickListener {
    //          val codigo = binding.txtCodigo.text.toString().toInt()
    //          val borrarEmpleado = Empleado(codigo, "", "", "")
    //          pViewModel.eliminar(borrarEmpleado)
    //      }
    //       binding.btnModificar.setOnClickListener {
    //           val codigo = binding.txtCodigo.text.toString().toInt()
    //           val nombres = binding.txtNom.text.toString()
    //          val apellido = binding.txtApellido.text.toString()
    //          val puesto = binding.txtPuesto.text.toString()
    //           val actualizarEmpleado = Empleado(codigo, nombres, apellido, puesto)
    //           pViewModel.actualizar(actualizarEmpleado)
    //     }
    //      pViewModel.empleados.observe(viewLifecycleOwner) { lista ->
    //         println("INFORMACION DE LA LISTA ${lista.size}")
    //         for (e in lista){
    //            println(e.toString())
    //        }
    //    }
    //  }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}