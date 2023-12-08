package pe.com.muebleria.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.muebleria.mapper.IClienteMapper;
import pe.com.muebleria.model.base.Cliente;
import pe.com.muebleria.model.request.cliente.ActualizarClienteRequest;
import pe.com.muebleria.model.request.cliente.EliminarClienteRequest;
import pe.com.muebleria.model.request.cliente.RegistrarClienteRequest;
import pe.com.muebleria.model.response.cliente.ActualizarClienteResponse;
import pe.com.muebleria.model.response.cliente.ClienteResponse;
import pe.com.muebleria.model.response.cliente.EliminarClienteResponse;
import pe.com.muebleria.model.response.cliente.ListarClienteResponse;
import pe.com.muebleria.model.response.cliente.RegistrarClienteResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IClienteService;

@Service
@AllArgsConstructor
public class ClienteService implements IClienteService {
	
	private @Autowired IClienteMapper clienteMapper;
	
	@Override
	public ListarClienteResponse listarTodos() {
		Cliente cliente = new Cliente();
		cliente.setAccion(Accion.listar);
		List<Cliente> listadoClientes = clienteMapper.listarTodos(cliente);
		List<ClienteResponse> listarClienteResponse = new ArrayList<>();
		
		listadoClientes.forEach(s -> listarClienteResponse.add(
				ClienteResponse.builder()
				.cod_cliente(s.getCod_cliente().toString())
				.nombre(s.getNombre())
				.apellido(s.getApellido())
				.build()
				)
				);
		
		
		return ListarClienteResponse.builder().listarCliente(listarClienteResponse).exito("SI").build();
	}

	@Override
	public RegistrarClienteResponse registrarCliente(RegistrarClienteRequest request,
			RegistrarClienteResponse response) {
		
		 Cliente cliente = new Cliente();
		  
		    cliente.setNombre(request.getNombre());
		    cliente.setApellido(request.getApellido());
		    
		    if (request.getCodigo() != null) {
		        cliente.setCod_cliente(Integer.parseInt(request.getCodigo()));
		    } else {
		        cliente.setCod_cliente(0); // Valor predeterminado si el código es nulo
		    }
		    
		    System.out.println("Registrar: " + cliente);
		this.clienteMapper.registrarCliente(cliente);

		return response;
	}

	@Override
	public ActualizarClienteResponse actualizarCliente(ActualizarClienteRequest request,
			ActualizarClienteResponse response) {
		
		Cliente cliente = new Cliente();
		cliente.setCod_cliente(request.getCod_cliente());
		cliente.setNombre(request.getNombre());
		cliente.setApellido(request.getApellido());
		cliente.setAccion(Accion.actualizar);		
		System.out.println("Actualizar: {}" + cliente);
		this.clienteMapper.actualizarCliente(cliente);
		
		response.setExito(cliente.getExito());
		
		return response;
	}

	@Override
	public EliminarClienteResponse eliminarCliente(Integer id, EliminarClienteResponse response) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setCod_cliente(id);
		cliente.setAccion(Accion.eliminar);
		System.out.println("Eliminar: {}"+ cliente);
		this.clienteMapper.eliminarCliente(cliente);
		
		response.setExito(cliente.getExito());
		
		return response;
	}

	@Override
	public List<Cliente> buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
