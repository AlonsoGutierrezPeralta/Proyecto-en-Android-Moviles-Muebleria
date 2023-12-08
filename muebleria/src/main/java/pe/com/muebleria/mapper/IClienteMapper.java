package pe.com.muebleria.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pe.com.muebleria.model.base.Cliente;

@Mapper
public interface IClienteMapper {
	
	public List<Cliente> listarTodos(Cliente cliente);
	
	public void registrarCliente(Cliente cliente);
	
	public void actualizarCliente(Cliente cliente);
	
	public void eliminarCliente(Cliente cliente);
	
	public void mantenimiento(Cliente cliente);
	
	
	
}
