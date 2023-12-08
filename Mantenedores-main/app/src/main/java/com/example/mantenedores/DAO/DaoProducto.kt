package com.example.mantenedores.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mantenedores.entity.Producto
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoProducto {

    @Query("SELECT * FROM tbl_producto")
    fun getProductos(): Flow<List<Producto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(producto: Producto)

    @Update
    suspend fun update(producto: Producto)

    @Delete
    suspend fun delete(producto: Producto)

    //   @Query("UPDATE cliente set nombre=:nombre, apellidos=:apellido WHERE codigo=:codigo")
    //  suspend fun actualizarCliente(codigo: Int, nombre: String, apellido:String)

    //  @Query("DELETE FROM cliente WHERE codigo=:codigo")
    //   suspend fun borrarCliente(codigo: Int)
}