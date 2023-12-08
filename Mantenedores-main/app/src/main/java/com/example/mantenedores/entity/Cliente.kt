package com.example.mantenedores.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "cod_cliente") val cod: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "apellido") val apellidos: String?): Serializable{

    override fun toString(): String{
        return "Cliente(id=$cod, nombre='$nombre', apellidos='$apellidos')"
    }
}


