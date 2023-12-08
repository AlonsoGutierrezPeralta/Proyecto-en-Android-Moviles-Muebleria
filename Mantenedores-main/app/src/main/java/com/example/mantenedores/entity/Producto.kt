package com.example.mantenedores.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tbl_producto")
data class Producto(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_prod") val id: Int = 0,
    @ColumnInfo(name = "nom_prov") val proveedor: String?,
    @ColumnInfo(name = "nom_prod") val nombre: String?,
    @ColumnInfo(name = "tipo") val tipo: String?,
    @ColumnInfo(name = "stk_prod") val stock: String?,
    @ColumnInfo(name = "pre_prod") val precio: Double?): Serializable{

    override fun toString(): String{
        return "Proveedor(id=$id, proveedor=$proveedor, nombre='$nombre', tipo='$tipo, stock='$stock, precio='$precio')"
    }
}


