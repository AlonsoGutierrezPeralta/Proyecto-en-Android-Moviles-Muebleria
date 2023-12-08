package pe.com.muebleria.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.com.muebleria.model.base.Proveedor;

@Mapper
public interface IProveedorMapper {

	public List<Proveedor> listarTodosProv(Proveedor proveedor);
	
	// public void mantenimiento(Proveedor proveedor);
	
	public void registrarProveedor(Proveedor proveedor);
	
	public void actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(Proveedor proveedor);
	
}
