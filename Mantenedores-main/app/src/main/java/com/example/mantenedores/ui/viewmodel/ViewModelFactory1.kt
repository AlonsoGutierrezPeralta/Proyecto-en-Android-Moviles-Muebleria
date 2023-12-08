package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.repository.EmpleadoRepository

class ViewModelFactory1 : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <E : ViewModel> create(modelClass: Class<E>): E {
        if (modelClass.isAssignableFrom(EmpleadoViewModel::class.java)){
            return EmpleadoViewModel(EmpleadoRepository(MuebleriaDataSource())) as E
        }
        return super.create(modelClass)
    }

}