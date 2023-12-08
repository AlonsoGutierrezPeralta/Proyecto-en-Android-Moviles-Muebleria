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
import pe.com.muebleria.model.base.Producto;
import pe.com.muebleria.model.request.producto.ActualizarProductoRequest;
import pe.com.muebleria.model.request.producto.EliminarProductoRequest;
import pe.com.muebleria.model.request.producto.RegistrarProductoRequest;
import pe.com.muebleria.model.response.producto.ActualizarProductoResponse;
import pe.com.muebleria.model.response.producto.EliminarProductoResponse;
import pe.com.muebleria.model.response.producto.ListarProductoResponse;
import pe.com.muebleria.model.response.producto.RegistrarProductoResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IProductoService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/muebleria/producto")
public class ProductoController 
{
	
	private @Autowired IProductoService productoService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public RegistrarProductoResponse registrarProducto(@RequestBody RegistrarProductoRequest request)
	{
		RegistrarProductoResponse response = new RegistrarProductoResponse();
		
		this.productoService.registrarProducto(request, response);
		
		return response;
	}
	
	@GetMapping("/listar") 
	public ListarProductoResponse listarProductos()
	{
		Producto producto = new Producto();
		System.out.println("LISTAR PRODUCTOS {},");
		producto.setAccion(Accion.listar);
		return productoService.listarTodos();
	}
	
	@PutMapping(path = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ActualizarProductoResponse actualizarrProducto(@RequestBody ActualizarProductoRequest request)
	{
		ActualizarProductoResponse response = new ActualizarProductoResponse();
		
		this.productoService.actualizarProducto(request, response);
		
		return response;
	}
	
	@DeleteMapping(path = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EliminarProductoResponse eliminarProducto(@PathVariable("id") Integer id)
	{
		EliminarProductoResponse response = new EliminarProductoResponse();
		
		this.productoService.eliminarProducto(id, response);
		
		return response;
	}
}
