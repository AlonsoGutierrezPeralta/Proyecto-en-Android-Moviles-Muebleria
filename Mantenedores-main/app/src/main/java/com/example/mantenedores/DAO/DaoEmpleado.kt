package com.example.mantenedores.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mantenedores.entity.Empleado
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoEmpleado {

    @Query("SELECT * FROM tb_empleados")
    fun getEmpleado(): Flow<List<Empleado>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(empleado: Empleado)

    @Update
    suspend fun update(empleado: Empleado)

    @Delete
    suspend fun delete(empleado: Empleado)

    //   @Query("UPDATE cliente set nombre=:nombre, apellidos=:apellido WHERE codigo=:codigo")
    //  suspend fun actualizarCliente(codigo: Int, nombre: String, apellido:String)

    //  @Query("DELETE FROM cliente WHERE codigo=:codigo")
    //   suspend fun borrarCliente(codigo: Int)
}