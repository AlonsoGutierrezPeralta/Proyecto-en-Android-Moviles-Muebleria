package com.example.mantenedores.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mantenedores.entity.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoCliente {

    @Query("SELECT * FROM tb_clientes")
    fun getClientes(): Flow<List<Cliente>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cliente: Cliente)

    @Update
    suspend fun update(cliente: Cliente)

    @Delete
    suspend fun delete(cliente: Cliente)

 //   @Query("UPDATE cliente set nombre=:nombre, apellidos=:apellido WHERE codigo=:codigo")
  //  suspend fun actualizarCliente(codigo: Int, nombre: String, apellido:String)

  //  @Query("DELETE FROM cliente WHERE codigo=:codigo")
 //   suspend fun borrarCliente(codigo: Int)
}