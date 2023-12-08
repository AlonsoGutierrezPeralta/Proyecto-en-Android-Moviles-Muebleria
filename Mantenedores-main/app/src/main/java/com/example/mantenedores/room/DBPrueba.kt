package com.example.mantenedores.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mantenedores.DAO.DaoCliente
import com.example.mantenedores.DAO.DaoEmpleado
import com.example.mantenedores.entity.Cliente
import com.example.mantenedores.entity.Empleado

@Database(entities = [Cliente::class], version = 1)
abstract class DBPrueba: RoomDatabase() {
    abstract fun daoCliente(): DaoCliente
   // abstract fun daoEmpleado(): DaoEmpleado
    //   abstract fun daoProducto(): DaoProducto
    //   abstract fun daoProveedor(): DaoProveedor

  //  val Migration = object : Migration (3, 4) {
  //      override fun migrate(database: SupportSQLiteDatabase) {
    //        database.execSQL("CREATE TABLE IF NOT EXISTS AuthoEntity ("+
    //                "id INT NOT NULL PRIMARY KEY,)")
   //     }
   // }

    companion object{
        private var INSTANCE: DBPrueba? = null

        fun getInstance(context: Context):DBPrueba{
            return INSTANCE ?: synchronized(this){
                val obj = Room.databaseBuilder(context, DBPrueba::class.java, "BDMuebleria").build()
                INSTANCE = obj
                obj
            }
        }
    }
}