package com.example.mantenedores.repository
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.data.ClienteJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON

class ClienteRepository (private val dataSource: MuebleriaDataSource){

    suspend fun insertar(cliente : ClienteJSON) : ResultadoJSON {
        val response = dataSource.registrarCliente(cliente)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun actualizar(cliente : ClienteJSON) : ResultadoJSON {
        val response = dataSource.actualizarCliente(cliente)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }
    suspend fun eliminar(cliente : ClienteJSON) : ResultadoJSON {
        val response = dataSource.eliminarCliente(cliente)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun listarCliente2() : ResultJSON<List<ClienteJSON>>
    {
        return when(val response = dataSource.listadoCliente2()){
            is ResultJSON.Exito ->{
                println("estoy en el repositrio" + response)
                val lista = response.data.lstCliente
                return ResultJSON.Exito(lista)
            }
            is ResultJSON.Problema -> {
                response
            }
        }
    }
}