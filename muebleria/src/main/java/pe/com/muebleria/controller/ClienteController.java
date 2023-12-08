package pe.com.muebleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.muebleria.model.base.Cliente;
import pe.com.muebleria.model.request.cliente.ActualizarClienteRequest;
import pe.com.muebleria.model.request.cliente.EliminarClienteRequest;
import pe.com.muebleria.model.request.cliente.RegistrarClienteRequest;
import pe.com.muebleria.model.response.cliente.ActualizarClienteResponse;
import pe.com.muebleria.model.response.cliente.EliminarClienteResponse;
import pe.com.muebleria.model.response.cliente.ListarClienteResponse;
import pe.com.muebleria.model.response.cliente.RegistrarClienteResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IClienteService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/muebleria/cliente")
public class ClienteController 
{
	
	private @Autowired IClienteService clienteService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public RegistrarClienteResponse registrarCliente(@RequestBody RegistrarClienteRequest request)
	{
		RegistrarClienteResponse response = new RegistrarClienteResponse();
		System.out.println("Datos del cliente:");
	    System.out.println("Nombre: " + request.getNombre());
	    System.out.println("Apellido: " + request.getApellido());
	    System.out.println("Código de cliente: " + request.getCodigo());
		
		
		this.clienteService.registrarCliente(request, response);
		return response;
	}
	
	@GetMapping("/listar")
	public ListarClienteResponse listarClientes()
	{
		Cliente cliente = new Cliente();
		System.out.println("--------- Imprime");
		cliente.setAccion(Accion.listar);
		return clienteService.listarTodos();
	}
	
	@PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ActualizarClienteResponse actualizarCliente(@RequestBody ActualizarClienteRequest request)
	{
		ActualizarClienteResponse response = new ActualizarClienteResponse();
		this.clienteService.actualizarCliente(request, response);
		return response;
	}
	
	 @DeleteMapping(path = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public EliminarClienteResponse eliminarCliente(@PathVariable("id") Integer id)
		{
			EliminarClienteResponse response = new EliminarClienteResponse();
			
			this.clienteService.eliminarCliente(id, response);
			
			return response;
		}
	
}
