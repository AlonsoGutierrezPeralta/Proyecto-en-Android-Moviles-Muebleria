package com.example.mantenedores.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_proveedor")
data class Proveedor(
    @PrimaryKey @ColumnInfo(name = "cod_provee") val cod: Int = 0,
    @ColumnInfo(name = "raz_prov") val razon: String?,
    @ColumnInfo(name = "ruc_prov") val ruc: String?): Serializable{

    override fun toString(): String{
        return "Proveedor(cod_prov=$cod, razon=$razon, ruc='$ruc')"
    }
}


