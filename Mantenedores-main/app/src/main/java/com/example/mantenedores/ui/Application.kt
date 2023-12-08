package com.example.mantenedores.ui

import android.app.Application
import com.example.mantenedores.data.MuebleriaDataSource
import com.example.mantenedores.repository.ClienteRepository
import com.example.mantenedores.repository.ProductoRepository
import com.example.mantenedores.room.DBPrueba

class Application: Application() {
    val database by lazy { DBPrueba.getInstance(this)}
    //val datasource by lazy { MuebleriaDataSource}
    // repository by lazy { ClienteRepository(database.daoCliente()) }
  //  val repository1 by lazy { EmpleadoRepository(database.daoEmpleado()) }
    //val repository2 by lazy { ProductoRepository(datasource) }
    //  val repository3 by lazy { ProveedorRepository(database.daoProveedor()) }
}