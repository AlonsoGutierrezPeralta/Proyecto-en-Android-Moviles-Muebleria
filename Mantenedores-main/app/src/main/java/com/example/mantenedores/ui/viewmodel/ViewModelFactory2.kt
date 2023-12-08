package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.Proveedor
import com.example.mantenedores.repository.ProveedorRepository

class ViewModelFactory2 : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProveedorViewModel::class.java)) {
            return ProveedorViewModel(ProveedorRepository(MuebleriaDataSource())) as T
        }
        return super.create(modelClass)
    }
}