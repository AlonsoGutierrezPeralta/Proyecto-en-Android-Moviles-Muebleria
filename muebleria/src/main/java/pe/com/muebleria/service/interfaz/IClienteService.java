package pe.com.muebleria.service.interfaz;

import java.util.List;

import pe.com.muebleria.model.base.Cliente;
import pe.com.muebleria.model.request.cliente.ActualizarClienteRequest;
import pe.com.muebleria.model.request.cliente.EliminarClienteRequest;
import pe.com.muebleria.model.request.cliente.RegistrarClienteRequest;
import pe.com.muebleria.model.response.cliente.ActualizarClienteResponse;
import pe.com.muebleria.model.response.cliente.EliminarClienteResponse;
import pe.com.muebleria.model.response.cliente.ListarClienteResponse;
import pe.com.muebleria.model.response.cliente.RegistrarClienteResponse;


public interface IClienteService {
	public ListarClienteResponse listarTodos();

	public RegistrarClienteResponse registrarCliente(RegistrarClienteRequest request, RegistrarClienteResponse response);
	
	public ActualizarClienteResponse actualizarCliente(ActualizarClienteRequest request, ActualizarClienteResponse response);
	

	public EliminarClienteResponse eliminarCliente(Integer id, EliminarClienteResponse response);
	
	public List<Cliente> buscarPorId(Integer id);

}