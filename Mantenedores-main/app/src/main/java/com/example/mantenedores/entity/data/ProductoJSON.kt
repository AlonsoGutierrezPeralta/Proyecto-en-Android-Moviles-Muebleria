package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductoJSON
    (
    @Json(name = "CODIGO_PRODUCTO")val codigoProducto : Int?,
    @Json(name = "CODIGO_PROVEEDOR")val codigoProveedor : Int?,
    @Json(name = "DESCRIPCION")val descripcion : String?,
    @Json(name = "TIPO")val tipo : Int?,
    @Json(name = "STOCK")val stock : Int?,
    @Json(name = "PRECIO")val precio : Double?,
)
{
}

