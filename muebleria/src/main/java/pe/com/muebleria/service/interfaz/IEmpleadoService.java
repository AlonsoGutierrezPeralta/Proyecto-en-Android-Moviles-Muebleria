package pe.com.muebleria.service.interfaz;

import java.util.List;
import pe.com.muebleria.model.base.Empleado;
import pe.com.muebleria.model.response.empleado.*;
import pe.com.muebleria.model.request.empleado.*;

public interface IEmpleadoService {

	public ListarEmpleadoResponse listarTodos();
	
	public RegistrarEmpleadoResponse registrarEmpleado(RegistrarEmpleadoRequest request,RegistrarEmpleadoResponse response);
	
	public ActualizarEmpleadoResponse actualizarEmpleado(ActualizarEmpleadoRequest request, ActualizarEmpleadoResponse response);
	
	public EliminarEmpleadoResponse eliminarEmpleado(Integer id, EliminarEmpleadoResponse response);
	
	public List<Empleado> buscarPorId(Integer id);
}
