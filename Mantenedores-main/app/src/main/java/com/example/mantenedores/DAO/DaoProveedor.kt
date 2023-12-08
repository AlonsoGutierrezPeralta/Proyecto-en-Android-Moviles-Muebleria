package com.example.mantenedores.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mantenedores.entity.Proveedor
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoProveedor {

    @Query("SELECT * FROM tb_proveedor")
    fun getProveedor(): Flow<List<Proveedor>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(proveedor: Proveedor)

    @Update
    suspend fun update(proveedor: Proveedor)

    @Delete
    suspend fun delete(proveedor: Proveedor)

    //   @Query("UPDATE cliente set nombre=:nombre, apellidos=:apellido WHERE codigo=:codigo")
    //  suspend fun actualizarCliente(codigo: Int, nombre: String, apellido:String)

    //  @Query("DELETE FROM cliente WHERE codigo=:codigo")
    //   suspend fun borrarCliente(codigo: Int)
}