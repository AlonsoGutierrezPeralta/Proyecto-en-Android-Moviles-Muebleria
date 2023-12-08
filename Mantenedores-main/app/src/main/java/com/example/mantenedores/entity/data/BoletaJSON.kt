package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BoletaJSON(
    @Json(name = "CODIGO_CLIENTE")val codCliente : String,
    @Json(name = "DETALLE_BOLETA")val detalleBoleta : List<DetalleBoletaJSON>
)
{
}