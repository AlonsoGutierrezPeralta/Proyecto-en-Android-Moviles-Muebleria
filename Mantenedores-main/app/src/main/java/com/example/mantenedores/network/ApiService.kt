package com.example.mantenedores.network

import com.example.mantenedores.entity.data.*
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService
{
    //Cliente
    @GET("cliente/listar")
    suspend fun listarCliente() : ListadoClienteJSON;

    @POST("cliente/registrar")
    suspend fun registrarCliente(@Body cliente: ClienteJSON ) : ResultadoJSON;

    @PUT("cliente/actualizar")
    suspend fun actualizarCliente(@Body cliente: ClienteJSON) : ResultadoJSON;

    @DELETE("cliente/eliminar/{id}")
    suspend fun eliminarCliente(@Path("id") codCli : Int) : ResultadoJSON;

    @GET("cliente/listar")
    suspend fun listarCliente2() : ListadoClienteJSON;
    //
    //Empleado

    @GET("empleado/listar")
    suspend fun listarEmpleado() : ListadoEmpleadoJSON;

    @POST("empleado/registrar")
    suspend fun registrarEmpleado(@Body empleado : EmpleadoJSON) : ResultadoJSON;

    @PUT("empleado/actualizar")
    suspend fun actualizarEmpleado(@Body empleado: EmpleadoJSON) : ResultadoJSON;

    @DELETE("empleado/eliminar/{id}")
    suspend fun eliminarEmpleado(@Path("id") id : Int) : ResultadoJSON;

    @GET("empleado/listar")
    suspend fun listarEmpledo2() : ListadoEmpleadoJSON;

    //PRODUCTO
    @GET("producto/listar")
    suspend fun listarProductos() : ListadoProductoJSON;

    @POST("producto/registrar")
    suspend fun registrarProducto(@Body producto : ProductoJSON) : ResultadoJSON;

    @PUT("producto/actualizar")
    suspend fun actualizarProducto(@Body producto: ProductoJSON) : ResultadoJSON;

    @DELETE("producto/eliminar/{id}")
    suspend fun eliminarProducto(@Path("id") id : Int) : ResultadoJSON;

    @GET("producto/listar")
    suspend fun listarProductos2() : ListadoProductoJSON;

    ///PROVEEDOR
    @GET("proveedor/listar")
    suspend fun listarProveedor() : ListadoProveedorJSON;

    @POST("proveedor/registrar")
    suspend fun registrarProveedor(@Body proveedor : ProveedorJSON) : ResultadoJSON;

    @PUT("proveedor/actualizar")
    suspend fun actualizarProveedor(@Body proveedor: ProveedorJSON) : ResultadoJSON;

    @DELETE("proveedor/eliminar/{id}")
    suspend fun eliminarProveedor(@Path("id") codProv : Int) : ResultadoJSON;

    @GET("proveedor/listar")
    suspend fun listarProveedor2() : ListadoProveedorJSON;

    //Boleta
    @POST("boleta/compra")
    suspend fun realizarCompra(@Body boleta : BoletaJSON) : ResultadoBoletaJSON
}