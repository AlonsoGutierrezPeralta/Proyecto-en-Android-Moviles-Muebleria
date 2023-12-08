package pe.com.muebleria.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.com.muebleria.model.base.Producto;

@Mapper
public interface IProductoMapper 
{
	
	public List<Producto> listarTodos(Producto producto);
	
	public void mantenimiento(Producto producto);
	/*
	public List<Producto> buscarPorId(Integer id);
	*/
}
