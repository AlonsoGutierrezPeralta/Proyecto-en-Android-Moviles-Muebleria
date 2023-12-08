package pe.com.muebleria.service.interfaz;

import java.util.List;

import pe.com.muebleria.model.base.Producto;
import pe.com.muebleria.model.request.producto.ActualizarProductoRequest;
import pe.com.muebleria.model.request.producto.EliminarProductoRequest;
import pe.com.muebleria.model.request.producto.RegistrarProductoRequest;
import pe.com.muebleria.model.response.producto.ActualizarProductoResponse;
import pe.com.muebleria.model.response.producto.EliminarProductoResponse;
import pe.com.muebleria.model.response.producto.ListarProductoResponse;
import pe.com.muebleria.model.response.producto.RegistrarProductoResponse;

public interface IProductoService 
{
	public ListarProductoResponse listarTodos();

	public RegistrarProductoResponse registrarProducto(RegistrarProductoRequest request, RegistrarProductoResponse response);
	
	public ActualizarProductoResponse actualizarProducto(ActualizarProductoRequest request, ActualizarProductoResponse response);
	
	public EliminarProductoResponse eliminarProducto(Integer id, EliminarProductoResponse response);
	
	public List<Producto> buscarPorId(Integer id);
}
