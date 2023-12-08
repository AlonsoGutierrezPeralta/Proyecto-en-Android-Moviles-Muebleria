package com.example.mantenedores.repository

import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.entity.data.ProductoJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON

class ProductoRepository(private val dataSource: MuebleriaDataSource){
/*
    val listaProductos: Flow<List<Producto>> = prodDao.getProductos()

    suspend fun insertar(producto: Producto){
        prodDao.insert(producto)
    }
    suspend fun actualizar(producto: Producto){
        prodDao.update(producto)
    }
    suspend fun eliminar(producto: Producto){
        prodDao.delete(producto)
    }
    */
/*
    suspend fun listarProductos() : ListadoProductoJSON
    {
        val response = dataSource.servicioPokemon()
        when (response){
            is ListadoProductoJSON -> {
                val lstProductos = response.lstProductos
                return ListadoProductoJSON("001", lstProductos)
            }
        }
        return ListadoProductoJSON("001", null)
    }
*/
    suspend fun insertar(producto : ProductoJSON) : ResultadoJSON{
        val response = dataSource.registrarProducto(producto)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun actualizar(producto : ProductoJSON) : ResultadoJSON{
        val response = dataSource.actualizarProducto(producto)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }
    suspend fun eliminar(producto : ProductoJSON) : ResultadoJSON{
        val response = dataSource.eliminarProducto(producto)
        when(response)
        {
            is ResultadoJSON ->{
                val resultado = response.exito
                return ResultadoJSON(resultado)
            }
        }
        return ResultadoJSON("NO")
    }

    suspend fun listarProductos2() : ResultJSON<List<ProductoJSON>>
    {
        return when(val response = dataSource.listadoProductos2()){
            is ResultJSON.Exito ->{
                println("estoy en el repositrio" + response)
                val lista = response.data.lstProductos
                return ResultJSON.Exito(lista)
            }
            is ResultJSON.Problema -> {
                response
            }
        }
    }
}