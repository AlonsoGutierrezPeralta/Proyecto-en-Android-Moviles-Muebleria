package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.*
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON
import com.example.mantenedores.repository.ProveedorRepository
import kotlinx.coroutines.launch

class ProveedorViewModel(private val repository: ProveedorRepository): ViewModel() {

    private var _listadoProveedor = MutableLiveData<ResultJSON<List<ProveedorJSON>>>()
    val listadoProveedor : LiveData<ResultJSON<List<ProveedorJSON>>> = _listadoProveedor

    fun listarProveedor()
    {
        viewModelScope.launch {
            val response = repository.listarProveedor2()
            _listadoProveedor.value = response
        }
    }

    private var resultado = ResultadoJSON("NO")
    fun registrarProveedor(proveedor : ProveedorJSON) {
        viewModelScope.launch{
            val response = repository.insertar(proveedor)
            resultado = response
        }
    }

    fun actualizarProveedor(proveedor : ProveedorJSON) {
        viewModelScope.launch{
            val response = repository.actualizar(proveedor)
            resultado = response
        }
    }

    fun eliminarProveedor(proveedor : ProveedorJSON) {
        viewModelScope.launch{
            val response = repository.eliminar(proveedor)
            resultado = response
        }
    }
}