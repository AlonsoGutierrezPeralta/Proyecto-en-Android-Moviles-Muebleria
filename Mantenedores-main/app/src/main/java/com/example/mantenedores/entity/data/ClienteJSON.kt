package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ClienteJSON(
    @Json(name = "NOMBRE")val nombre : String?,
    @Json(name = "APELLIDO")val apellido : String?,
    @Json(name = "CODIGO_CLIENTE")val codCli : Int?,
)
{

}

