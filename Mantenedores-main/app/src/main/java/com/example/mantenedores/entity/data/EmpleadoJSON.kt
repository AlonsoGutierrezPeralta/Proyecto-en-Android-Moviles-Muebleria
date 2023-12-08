package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmpleadoJSON
    (
    @Json(name = "CODIGO_EMPLEADO")val codigoEmpleado : Int?,
    @Json(name = "NOMBRE")val nombre : String?,
    @Json(name = "APELLIDO")val apellido : String?,
    @Json(name = "PUESTO")val puesto : Int?,
)
{
}