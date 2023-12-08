package com.example.mantenedores.repository

import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.data.BoletaJSON
import com.example.mantenedores.entity.data.ResultadoBoletaJSON
import com.example.mantenedores.entity.data.ResultadoJSON

class BoletaRepository(private val dataSource: MuebleriaDataSource)
{
    suspend fun realizarCompra(boleta : BoletaJSON) : ResultadoBoletaJSON{
        val response = dataSource.realizarBoleta(boleta)
        when(response)
        {
            is ResultadoBoletaJSON ->{
                val resultado = response
                println("----------------Reporsitorio: " + resultado)
                return response
            }
        }
        return response
    }
}