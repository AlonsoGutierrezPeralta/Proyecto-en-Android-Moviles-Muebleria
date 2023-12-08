package pe.com.muebleria.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.muebleria.mapper.IProductoMapper;
import pe.com.muebleria.model.base.Producto;
import pe.com.muebleria.model.request.producto.ActualizarProductoRequest;
import pe.com.muebleria.model.request.producto.EliminarProductoRequest;
import pe.com.muebleria.model.request.producto.RegistrarProductoRequest;
import pe.com.muebleria.model.response.producto.ActualizarProductoResponse;
import pe.com.muebleria.model.response.producto.EliminarProductoResponse;
import pe.com.muebleria.model.response.producto.ListarProductoResponse;
import pe.com.muebleria.model.response.producto.ProductoResponse;
import pe.com.muebleria.model.response.producto.RegistrarProductoResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IProductoService;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService
{
	private @Autowired IProductoMapper productoMapper;

	@Override
	public ListarProductoResponse listarTodos() 
	{	
		Producto producto = new Producto();
		producto.setAccion(Accion.listar);
		List<Producto> listadoProductos = productoMapper.listarTodos(producto);
		List<ProductoResponse> listarProductoResponse = new ArrayList<>();
		
		
		listadoProductos.forEach(s -> listarProductoResponse.add(
				ProductoResponse.builder()
				.codigoProducto(s.getCodigoProducto().toString())
				.codigoProveedor(s.getCodigoProveedor())
				.descripcionProducto(s.getDescripcionProducto())
				.idTipo(s.getIdTipo())
				.stock(s.getStock())
				.precio(s.getPrecio())
				.build()
				)
				);
		producto.setExito("SI");
		ListarProductoResponse response = ListarProductoResponse.builder().listarProductos(listarProductoResponse).build();
		response.setExito("SI");
		return response;
		
	}


	@Override
	public List<Producto> buscarPorId(Integer id) 
	{
		return null;
	}

	@Override
	public RegistrarProductoResponse registrarProducto(RegistrarProductoRequest request, RegistrarProductoResponse response)
	{
		
		Producto producto = new Producto();
		
		producto.setCodigoProveedor(request.getCodigoProveedor());
		producto.setDescripcionProducto(request.getDescripcionProducto());
		producto.setIdTipo(request.getIdTipo());
		producto.setStock(request.getStock());
		producto.setPrecio(request.getPrecio());
		producto.setAccion(Accion.registrar);
		System.out.println("Registrar: {}" + producto);
		this.productoMapper.mantenimiento(producto);
		
		response.setExito(producto.getExito());
		
		return response;
	}


	@Override
	public ActualizarProductoResponse actualizarProducto(ActualizarProductoRequest request,
			ActualizarProductoResponse response) 
	{
		Producto producto = new Producto();
		producto.setCodigoProducto(request.getCodigoProducto());
		producto.setCodigoProveedor(request.getCodigoProveedor());
		producto.setDescripcionProducto(request.getDescripcionProducto());
		producto.setIdTipo(request.getIdTipo());
		producto.setStock(request.getStock());
		producto.setPrecio(request.getPrecio());
		producto.setAccion(Accion.actualizar);
		System.out.println("Actualizar: {}"+ producto);
		this.productoMapper.mantenimiento(producto);
		
		response.setExito(producto.getExito());
		
		return response;
	}


	@Override
	public EliminarProductoResponse eliminarProducto(Integer id,
			EliminarProductoResponse response) 
	{
		Producto producto = new Producto();
		producto.setCodigoProducto(id);
		producto.setAccion(Accion.eliminar);
		System.out.println("Eliminar: {}"+ producto);
		this.productoMapper.mantenimiento(producto);
		
		response.setExito(producto.getExito());
		
		return response;
	}
	
	
}
