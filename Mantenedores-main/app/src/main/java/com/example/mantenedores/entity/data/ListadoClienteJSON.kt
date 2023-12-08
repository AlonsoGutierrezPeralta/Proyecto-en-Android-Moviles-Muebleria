package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ListadoClienteJSON (
    @Json(name = "EXITO")val exito : String,
    @Json(name = "LISTADO_CLIENTE")val lstCliente : List<ClienteJSON>,

    )
{
}