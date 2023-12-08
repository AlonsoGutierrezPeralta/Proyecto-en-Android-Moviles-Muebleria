package com.example.mantenedores.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_empleados")
data class Empleado(
    @PrimaryKey @ColumnInfo(name = "codigo") val codigo: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "apellido") val apellidos: String?,
    @ColumnInfo(name = "puesto") val puesto: String?): Serializable{

    override fun toString(): String{
        return "Empleado(codigo=$codigo, nombre='$nombre', apellidos='$apellidos', puesto='$puesto')"
    }
}


