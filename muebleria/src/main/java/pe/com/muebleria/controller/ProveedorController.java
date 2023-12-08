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
import pe.com.muebleria.model.base.Proveedor;
import pe.com.muebleria.model.request.proveedor.ActualizarProveedorRequest;
import pe.com.muebleria.model.request.proveedor.RegistrarProveedorRequest;
import pe.com.muebleria.model.response.proveedor.ActualizarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.EliminarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.ListarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.RegistrarProveedorResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IProveedorService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/muebleria/proveedor")
public class ProveedorController 
{
	
	private @Autowired IProveedorService proveedorService;
	
	@PostMapping(path= "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public RegistrarProveedorResponse registrarProveedor(@RequestBody RegistrarProveedorRequest request) 
	{
		RegistrarProveedorResponse response = new RegistrarProveedorResponse();
		
		this.proveedorService.registrarProveedor(request, response);
		
		return response;
		
	}
	
	@GetMapping("/listar")
	public ListarProveedorResponse listarProveedor()
	{
		Proveedor proveedor = new Proveedor();
		System.out.println("LISTAR PROVEEDOR {},");
		proveedor.setAccion(Accion.listar);
		return proveedorService.listarTodosProv();
	}

	@PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ActualizarProveedorResponse actualizarProveedor(@RequestBody ActualizarProveedorRequest request)
	{
		ActualizarProveedorResponse response = new ActualizarProveedorResponse();
		this.proveedorService.actualizarProveedor(request, response);
		return response;
	}
	
	@DeleteMapping(path = "/eliminar/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
	public EliminarProveedorResponse eliminarProveedor(@PathVariable("id") Integer id)
	{
		EliminarProveedorResponse response = new EliminarProveedorResponse();
		this.proveedorService.eliminarProveedor(id, response);
		return response;
	}
}
