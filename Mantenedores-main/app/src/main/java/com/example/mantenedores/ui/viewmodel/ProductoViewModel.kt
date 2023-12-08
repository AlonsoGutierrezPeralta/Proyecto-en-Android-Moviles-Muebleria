package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mantenedores.entity.Producto
import com.example.mantenedores.entity.data.ListadoProductoJSON
import com.example.mantenedores.entity.data.ProductoJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON
import com.example.mantenedores.repository.ProductoRepository
import kotlinx.coroutines.launch

class ProductoViewModel(private val repository: ProductoRepository): ViewModel() {
/*
    val producto: LiveData<List<Producto>> = repository.listaProductos.asLiveData()

    fun insertar(producto: Producto) {
        viewModelScope.launch {
            repository.insertar(producto)
        }
    }
    fun actualizar(producto: Producto) {
        viewModelScope.launch {
            repository.actualizar(producto)
        }
    }
    fun eliminar(producto: Producto) {
        viewModelScope.launch {
            repository.eliminar(producto)
        }
    }*/
    /*
    private var _listaProducto = MutableLiveData<ListadoProductoJSON>()
    val listaProducto : LiveData<ListadoProductoJSON> = _listaProducto
    fun listarProductos()
    {
        viewModelScope.launch {
            val response = repository.listarProductos()
            _listaProducto.value = response
        }
    }
*/

    private var _listadoProductos = MutableLiveData<ResultJSON<List<ProductoJSON>>>()
    val listadoProductos : LiveData<ResultJSON<List<ProductoJSON>>> = _listadoProductos

    fun listarProductos()
    {
        viewModelScope.launch {
            val response = repository.listarProductos2()
            _listadoProductos.value = response
        }
    }

    private var resultado = ResultadoJSON("NO")
    fun registrarProducto(producto : ProductoJSON) {
        viewModelScope.launch{
            val response = repository.insertar(producto)
            resultado = response
        }
    }

    fun actualizarProducto(producto : ProductoJSON) {
        viewModelScope.launch{
            val response = repository.actualizar(producto)
            resultado = response
        }
    }

    fun eliminarProducto(producto : ProductoJSON) {
        viewModelScope.launch{
            val response = repository.eliminar(producto)
            resultado = response
        }
    }

}