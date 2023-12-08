package com.example.mantenedores.data

import com.example.mantenedores.entity.data.*
import com.example.mantenedores.network.ConexionApi
import java.net.SocketTimeoutException

class MuebleriaDataSource {
    private val conexionApi = ConexionApi.retrofitService
    /*
    suspend fun servicioPokemon() : ListadoProductoJSON {
        return try {
            println("Estoy en Datasource")
            val result = conexionApi.listarProductos()
            println(result)
            result
        } catch (ex: SocketTimeoutException) {
            ListadoProductoJSON("NO", null)
        }
    }
*/
    //CLIENTEEEE

    ///Cliente
    suspend fun registrarCliente(cliente: ClienteJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.registrarCliente(cliente)
            result
        }catch (ex: java.lang.Exception)
        {
            ResultadoJSON("NO")
        }
    }
    suspend fun actualizarCliente(cliente: ClienteJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.actualizarCliente(cliente)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun eliminarCliente(cliente: ClienteJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.eliminarCliente(cliente.codCli!!)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun listadoCliente2() : ResultJSON<ListadoClienteJSON>
    {
        return try{
            val result = ConexionApi.retrofitService.listarCliente()
            ResultJSON.Exito(result)
        }catch (ex: Exception) {
            return ResultJSON.Problema(Error("NO"))
        } catch (ex: SocketTimeoutException) {
            return ResultJSON.Problema(Error("NO"))
        }
    }


    suspend fun registrarProducto(producto : ProductoJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.registrarProducto(producto)
            result
        }catch (ex: java.lang.Exception)
        {
            ResultadoJSON("NO")
        }
    }
    suspend fun actualizarProducto(producto : ProductoJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.actualizarProducto(producto)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun eliminarProducto(producto : ProductoJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.eliminarProducto(producto.codigoProducto!!)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun listadoProductos2() : ResultJSON<ListadoProductoJSON>
    {
        return try{
            val result = ConexionApi.retrofitService.listarProductos()
            ResultJSON.Exito(result)
        }catch (ex: Exception) {
            return ResultJSON.Problema(Error("NO"))
        } catch (ex: SocketTimeoutException) {
            return ResultJSON.Problema(Error("NO"))
        }
    }
///EMPLEADOOOOOOOO
    suspend fun registrarEmpleado(empleado: EmpleadoJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.registrarEmpleado(empleado)
            result
        }catch (ex: java.lang.Exception)
        {
            ResultadoJSON("NO")
        }
    }
    suspend fun actualizarEmpleado(empleado: EmpleadoJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.actualizarEmpleado(empleado)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun eliminarEmpleado(empleado: EmpleadoJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.eliminarEmpleado(empleado.codigoEmpleado!!)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun listadoEmpleado2() : ResultJSON<ListadoEmpleadoJSON>
    {
        return try{
            val result = ConexionApi.retrofitService.listarEmpleado()

            ResultJSON.Exito(result)
        }catch (ex: Exception) {
            println("Error ${ex}")
            return ResultJSON.Problema(Error("NO"))
        } catch (ex: SocketTimeoutException) {
            println("Error ${ex}")
            return ResultJSON.Problema(Error("NO"))
        }
    }

    ///
    suspend fun registrarProveedor(proveedor: ProveedorJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.registrarProveedor(proveedor)
            result
        }catch (ex: java.lang.Exception)
        {
            ResultadoJSON("NO")
        }
    }
    suspend fun actualizarProveedor(proveedor: ProveedorJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.actualizarProveedor(proveedor)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun eliminarProveedor(proveedor: ProveedorJSON) : ResultadoJSON{
        return try {
            val result = conexionApi.eliminarProveedor(proveedor.codProv!!)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoJSON("NO")
        }
    }

    suspend fun listadoProveedor2() : ResultJSON<ListadoProveedorJSON>
    {
        return try{
            val result = ConexionApi.retrofitService.listarProveedor()
            ResultJSON.Exito(result)
        }catch (ex: Exception) {
            return ResultJSON.Problema(Error("NO"))
        } catch (ex: SocketTimeoutException) {
            return ResultJSON.Problema(Error("NO"))
        }
    }

    suspend fun realizarBoleta(boleta : BoletaJSON) : ResultadoBoletaJSON
    {
        return try {
            val result = conexionApi.realizarCompra(boleta)
            result
        }catch (ex: java.lang.Exception)
        {
            println(ex.message)
            ResultadoBoletaJSON("-999","NO")
        }
    }
}