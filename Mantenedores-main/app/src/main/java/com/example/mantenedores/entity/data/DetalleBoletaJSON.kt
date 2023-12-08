package com.example.mantenedores.entity.data

import com.squareup.moshi.Json

data class DetalleBoletaJSON(
    @Json(name = "CODIGO_PRODUCTO")val codProducto: String,
    @Json(name = "CANTIDAD")val cantidad: Int,
    @Json(name = "PRECIO")val precio: Double
)
{
}