package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListadoProductoJSON(
    @Json(name = "EXITO")val exito : String,
    @Json(name = "LISTADO_PRODUCTOS")val lstProductos : List<ProductoJSON>,
)
{
}