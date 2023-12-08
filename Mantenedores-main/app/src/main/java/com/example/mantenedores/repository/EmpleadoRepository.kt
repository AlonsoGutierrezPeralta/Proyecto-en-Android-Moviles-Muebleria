package com.example.mantenedores.repository

import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.data.EmpleadoJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON

class EmpleadoRepository(private val dataSource: MuebleriaDataSource){
    suspend fun insertar(empleado: EmpleadoJSON) : ResultadoJSON {
        val response = dataSource.registrarEmpleado(empleado)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun actualizar(empleado: EmpleadoJSON) : ResultadoJSON {
        val response = dataSource.actualizarEmpleado(empleado)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }
    suspend fun eliminar(empleado : EmpleadoJSON) : ResultadoJSON {
        val response = dataSource.eliminarEmpleado(empleado)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun listarEmpleado2() : ResultJSON<List<EmpleadoJSON>>
    {
        return when(val response = dataSource.listadoEmpleado2()){
            is ResultJSON.Exito ->{
                println("estoy en el repositrio" + response)
                val lista = response.data.lstEmpleado
                return ResultJSON.Exito(lista)
            }
            is ResultJSON.Problema -> {
                response
            }
        }
    }
}