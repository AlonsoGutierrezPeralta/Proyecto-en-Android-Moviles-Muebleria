package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultadoJSON(
    @Json(name = "EXITO")val exito : String,
    ) {
}