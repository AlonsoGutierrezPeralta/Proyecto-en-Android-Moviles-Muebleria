package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.data.BoletaJSON
import com.example.mantenedores.entity.data.ResultadoBoletaJSON
import com.example.mantenedores.entity.data.ResultadoJSON
import com.example.mantenedores.repository.BoletaRepository
import com.example.mantenedores.repository.ProductoRepository
import kotlinx.coroutines.launch

class TransaccionViewModel(private val repository: BoletaRepository) : ViewModel()
{
    private var _resultado = MutableLiveData<ResultadoBoletaJSON>()
    val resultado : LiveData<ResultadoBoletaJSON> = _resultado
    fun realizarCompra(boleta : BoletaJSON)
    {
        viewModelScope.launch {
            val response = repository.realizarCompra(boleta)
            _resultado.value = response
        }
    }
}