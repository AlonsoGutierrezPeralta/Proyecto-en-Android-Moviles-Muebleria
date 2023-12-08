package pe.com.muebleria.service.implementacion;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import pe.com.muebleria.model.base.Empleado;
import pe.com.muebleria.mapper.IEmpleadoMapper;
import pe.com.muebleria.model.request.empleado.*;
import pe.com.muebleria.model.response.empleado.*;
import pe.com.muebleria.service.interfaz.IEmpleadoService;
import pe.com.muebleria.parametros.Accion;


@Service
@AllArgsConstructor
public class EmpleadoService implements IEmpleadoService{

	private @Autowired IEmpleadoMapper empleadoMapper;
	
	@Override
	public ListarEmpleadoResponse listarTodos() {
		Empleado empleado = new Empleado();
		empleado.setAccion(Accion.listar);
		List<Empleado> listadoEmpleado = empleadoMapper.listarTodos(empleado);
		List<EmpleadoResponse> listarEmpleadoResponse = new ArrayList<>();
		
		listadoEmpleado.forEach(s -> listarEmpleadoResponse.add(
				EmpleadoResponse.builder()
				.codigo(s.getCodigo())
				.nombre(s.getNombre())
				.apellido(s.getApellido())
				.puesto(s.getPuesto())
				.build()
				)
				);
		
		
		return ListarEmpleadoResponse.builder().listarEmpleado(listarEmpleadoResponse).exito("SI").build();
	}

	@Override
	public RegistrarEmpleadoResponse registrarEmpleado(RegistrarEmpleadoRequest request,
			RegistrarEmpleadoResponse response) {
		Empleado empleado = new Empleado();
		
		if(request.getCodigo() != null) {
			empleado.setCodigo(Integer.parseInt(request.getCodigo()));
		}else {
			empleado.setCodigo(0);
		}
		
			empleado.setNombre(request.getNombre());
			empleado.setApellido(request.getApellido());
			
			
			if(request.getPuesto() !=null) {
				empleado.setPuesto(Integer.parseInt(request.getPuesto()));
			}else {
				empleado.setPuesto(0);
			}
			System.out.println("Registrar: "+empleado);
			this.empleadoMapper.registrarEmpleado(empleado);
		
		return response;
	}

	@Override
	public ActualizarEmpleadoResponse actualizarEmpleado(ActualizarEmpleadoRequest request,
			ActualizarEmpleadoResponse response) {
		
		Empleado empleado = new Empleado();
		empleado.setCodigo(request.getCodigo());
		empleado.setNombre(request.getNombre());
		empleado.setApellido(request.getApellido());
		empleado.setPuesto(request.getPuesto());
		System.out.println("Actualizar: {}"+empleado);
		this.empleadoMapper.actualizarEmpleado(empleado);
		
		response.setExito(empleado.getExito());
		
		return response;
	}

	@Override
	public EliminarEmpleadoResponse eliminarEmpleado(Integer id,
			EliminarEmpleadoResponse response) {
		
		Empleado empleado = new Empleado();
		empleado.setCodigo(id);
		empleado.setAccion(Accion.eliminar);
		System.out.println("Eliminar: {}"+empleado);
		this.empleadoMapper.eliminarEmpleado(empleado);
		
		response.setExito(empleado.getExito());
		
		return response;
	}

	@Override
	public List<Empleado> buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
