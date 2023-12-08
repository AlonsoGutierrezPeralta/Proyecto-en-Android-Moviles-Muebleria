package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListadoEmpleadoJSON(
    @Json(name = "EXITO")val exito : String,
    @Json(name = "LISTADO_EMPLEADO")val lstEmpleado : List<EmpleadoJSON>,
)
{
}
