package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.repository.ProductoRepository

class ViewModelFactory3 : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductoViewModel::class.java)) {
            return ProductoViewModel(ProductoRepository(MuebleriaDataSource())) as T
        }
        return super.create(modelClass)
    }
}