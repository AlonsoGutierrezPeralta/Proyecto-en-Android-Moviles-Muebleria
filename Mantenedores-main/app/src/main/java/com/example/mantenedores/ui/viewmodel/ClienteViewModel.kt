package com.example.mantenedores.ui.viewmodel
import androidx.lifecycle.*
import com.example.mantenedores.entity.Cliente
import com.example.mantenedores.entity.data.ClienteJSON
import com.example.mantenedores.entity.data.ProveedorJSON
import com.example.mantenedores.entity.data.ResultJSON
import com.example.mantenedores.entity.data.ResultadoJSON
import com.example.mantenedores.repository.ClienteRepository
import kotlinx.coroutines.launch

class ClienteViewModel(private val repository: ClienteRepository): ViewModel() {

    private var _listadoCliente = MutableLiveData<ResultJSON<List<ClienteJSON>>>()
    val listadoCliente : LiveData<ResultJSON<List<ClienteJSON>>> = _listadoCliente

    fun listarCliente()
    {
        viewModelScope.launch {
            val response = repository.listarCliente2()
            _listadoCliente.value = response
        }
    }

    private var resultado = ResultadoJSON("NO")
    fun registrarCliente(cliente : ClienteJSON) {
        viewModelScope.launch{
            val response = repository.insertar(cliente)
            resultado = response
        }
    }

    fun actualizarCliente(cliente : ClienteJSON) {
        viewModelScope.launch{
            val response = repository.actualizar(cliente)
            resultado = response
        }
    }

    fun eliminarCliente(cliente : ClienteJSON) {
        viewModelScope.launch{
            val response = repository.eliminar(cliente)
            resultado = response
        }
    }
}
