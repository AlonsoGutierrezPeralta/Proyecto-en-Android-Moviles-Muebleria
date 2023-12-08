package pe.com.muebleria.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.com.muebleria.model.base.Empleado;

@Mapper
public interface IEmpleadoMapper {
	
	public List<Empleado> listarTodos(Empleado empleado);
	
	public void registrarEmpleado(Empleado empleado);
	
	public void actualizarEmpleado(Empleado empleado);
	
	public void eliminarEmpleado(Empleado empleado);
	
	public void mantenimiento(Empleado empleado);
	
}
