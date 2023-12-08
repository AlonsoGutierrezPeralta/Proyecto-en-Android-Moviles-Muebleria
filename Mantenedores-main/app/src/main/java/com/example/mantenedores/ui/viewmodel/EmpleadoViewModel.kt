package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mantenedores.entity.*
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON
import com.example.mantenedores.repository.EmpleadoRepository
import kotlinx.coroutines.launch

class EmpleadoViewModel (private val repository1: EmpleadoRepository): ViewModel(){

    private var _listadoEmpleados = MutableLiveData<ResultJSON<List<EmpleadoJSON>>>()
    val listadoEmpleado : LiveData<ResultJSON<List<EmpleadoJSON>>> = _listadoEmpleados

    fun listarEmpleado()
    {
        viewModelScope.launch {
            val response = repository1.listarEmpleado2()
            println(response)
            _listadoEmpleados.value = response
        }
    }

    private var resultado = ResultadoJSON("NO")
    fun registrarEmpleado(empleado: EmpleadoJSON) {
        viewModelScope.launch{
            val response = repository1.insertar(empleado)
            resultado = response
        }
    }

    fun actualizarEmpleado(empleado : EmpleadoJSON) {
        viewModelScope.launch{
            val response = repository1.actualizar(empleado)
            resultado = response
        }
    }

    fun eliminarEmpleado(empleado : EmpleadoJSON) {
        viewModelScope.launch{
            val response = repository1.eliminar(empleado)
            resultado = response
        }
    }
}