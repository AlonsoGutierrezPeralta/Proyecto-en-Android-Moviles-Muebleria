package com.example.mantenedores.entity.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProveedorJSON
    (
    @Json(name = "RAZ_SOCIAL")val razSocial : String?,
    @Json(name = "RUC")val ruc : Int?,
    @Json(name = "CODIGO_PROVEEDOR")val codProv : Int?,
)
{
}