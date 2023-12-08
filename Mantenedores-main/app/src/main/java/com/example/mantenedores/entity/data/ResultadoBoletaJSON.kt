package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResultadoBoletaJSON(
    @Json(name = "NUMERO_BOLETA")val numeroBoleta : String,
    @Json(name = "EXITO")val exito : String
) {
}