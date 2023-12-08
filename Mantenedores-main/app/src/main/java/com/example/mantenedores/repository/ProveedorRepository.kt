package com.example.mantenedores.repository

import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON

class ProveedorRepository (private val dataSource: MuebleriaDataSource){

    suspend fun insertar(proveedor : ProveedorJSON) : ResultadoJSON {
        val response = dataSource.registrarProveedor(proveedor)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun actualizar(proveedor : ProveedorJSON) : ResultadoJSON {
        val response = dataSource.actualizarProveedor(proveedor)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }
    suspend fun eliminar(proveedor : ProveedorJSON) : ResultadoJSON {
        val response = dataSource.eliminarProveedor(proveedor)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun listarProveedor2() : ResultJSON<List<ProveedorJSON>>
    {
        return when(val response = dataSource.listadoProveedor2()){
            is ResultJSON.Exito ->{
                println("estoy en el repositrio" + response)
                val lista = response.data.lstProveedor
                return ResultJSON.Exito(lista)
            }
            is ResultJSON.Problema -> {
                response
            }
        }
    }
}