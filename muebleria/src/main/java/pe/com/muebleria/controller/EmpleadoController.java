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
import pe.com.muebleria.model.base.Empleado;
import pe.com.muebleria.model.request.empleado.*;
import pe.com.muebleria.model.response.empleado.*;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IEmpleadoService;

@RestController
@AllArgsConstructor
@RequestMapping("api/muebleria/empleado")
public class EmpleadoController {

	private @Autowired IEmpleadoService empleadoService;
	
	@PostMapping(path = "/registrar",produces = MediaType.APPLICATION_JSON_VALUE)
	public RegistrarEmpleadoResponse registrarEmpleado(@RequestBody RegistrarEmpleadoRequest request)
	{
		RegistrarEmpleadoResponse response = new RegistrarEmpleadoResponse();
		System.out.println("Datos del Empleado:");
		System.out.println("Código de empleado: " + request.getCodigo());
		System.out.println("Nombre: " + request.getNombre());
	    System.out.println("Apellido: " + request.getApellido());
	    System.out.println("Puesto: " + request.getPuesto());
	    
	    this.empleadoService.registrarEmpleado(request, response);
	    return response;
	}
	
	@GetMapping("/listar")
	public ListarEmpleadoResponse listarEmpleado()
	{
		Empleado empleado = new Empleado();
		System.out.println("LISTAR EMPLEADOS {}");
		empleado.setAccion(Accion.listar);
		return empleadoService.listarTodos();
	}
	
	@PutMapping(path="/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ActualizarEmpleadoResponse actualizarEmpleado(@RequestBody ActualizarEmpleadoRequest request)
	{
		ActualizarEmpleadoResponse response = new ActualizarEmpleadoResponse();
		this.empleadoService.actualizarEmpleado(request, response);
		return response;
	}
	
	@DeleteMapping(path = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EliminarEmpleadoResponse eliminarEmpleado(@PathVariable("id") Integer id)
	{
		EliminarEmpleadoResponse response = new EliminarEmpleadoResponse();
		this.empleadoService.eliminarEmpleado(id, response);
		return response;
	}
	
}
