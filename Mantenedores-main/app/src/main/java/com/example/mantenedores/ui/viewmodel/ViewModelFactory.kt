package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.repository.ClienteRepository
import com.example.mantenedores.repository.EmpleadoRepository
import com.example.mantenedores.repository.ProveedorRepository

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClienteViewModel::class.java)) {
            return ClienteViewModel(ClienteRepository(MuebleriaDataSource())) as T
        }
        return super.create(modelClass)
    }

}
