package com.example.mantenedores.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.repository.BoletaRepository

class TransaccionViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransaccionViewModel::class.java)) {
            return TransaccionViewModel(BoletaRepository(MuebleriaDataSource())) as T
        }
        return super.create(modelClass)
    }
}