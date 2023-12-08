package pe.com.muebleria.service.interfaz;

import java.util.List;

import pe.com.muebleria.model.base.Proveedor;
import pe.com.muebleria.model.request.proveedor.ActualizarProveedorRequest;
import pe.com.muebleria.model.request.proveedor.RegistrarProveedorRequest;
import pe.com.muebleria.model.response.proveedor.ActualizarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.EliminarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.ListarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.RegistrarProveedorResponse;

public interface IProveedorService 
{
	
	public ListarProveedorResponse listarTodosProv();
	
	public RegistrarProveedorResponse registrarProveedor(RegistrarProveedorRequest request, RegistrarProveedorResponse response);
	
	public ActualizarProveedorResponse actualizarProveedor(ActualizarProveedorRequest request, ActualizarProveedorResponse response);
	
	public EliminarProveedorResponse eliminarProveedor(Integer id, EliminarProveedorResponse response);
	
	public List<Proveedor> buscarPorId(Integer id);
 
 
}
