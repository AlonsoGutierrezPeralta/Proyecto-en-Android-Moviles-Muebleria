package pe.com.muebleria.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.muebleria.mapper.IProveedorMapper;
import pe.com.muebleria.model.base.Proveedor;
import pe.com.muebleria.model.request.proveedor.ActualizarProveedorRequest;
import pe.com.muebleria.model.request.proveedor.RegistrarProveedorRequest;
import pe.com.muebleria.model.response.proveedor.ActualizarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.EliminarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.ListarProveedorResponse;
import pe.com.muebleria.model.response.proveedor.ProveedorResponse;
import pe.com.muebleria.model.response.proveedor.RegistrarProveedorResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IProveedorService;

@Service
@AllArgsConstructor
public class ProveedorService implements IProveedorService{
	
	private @Autowired IProveedorMapper proveedorMapper;
	
	@Override
	public ListarProveedorResponse listarTodosProv() 
	{
		Proveedor proveedor = new Proveedor();
		proveedor.setAccion(Accion.listar);
		List<Proveedor> listadoProveedores = proveedorMapper.listarTodosProv(proveedor);
		List<ProveedorResponse> listarProveedorResponse = new ArrayList<>();
		
		listadoProveedores.forEach(s -> listarProveedorResponse.add(
				ProveedorResponse.builder()
				.raz_soc(s.getRaz_soc())
				.ruc(s.getRuc())
				.cod_provee(s.getCod_provee())
				.build()
				)
				);
		proveedor.setExito("SI");
		ListarProveedorResponse response = ListarProveedorResponse.builder().listarProveedor(listarProveedorResponse).build();
		response.setExito("SI");
		return response;
	}

	@Override
	public RegistrarProveedorResponse registrarProveedor(RegistrarProveedorRequest request,
			RegistrarProveedorResponse response) {
		
		Proveedor proveedor = new Proveedor();
		
		proveedor.setRaz_soc(request.getRaz_soc());
		proveedor.setRuc(request.getRuc());
		proveedor.setCod_provee(request.getCod_provee());
		proveedor.setAccion(Accion.registrar);
		System.out.println("Registrar: {}" + proveedor);
		this.proveedorMapper.registrarProveedor(proveedor);;
		
		response.setExito(proveedor.getExito());
		
		return response;
	}

	@Override
	public ActualizarProveedorResponse actualizarProveedor(ActualizarProveedorRequest request,
			ActualizarProveedorResponse response) 
	{
		
		Proveedor proveedor = new Proveedor();
		proveedor.setRaz_soc(request.getRaz_soc());
		proveedor.setRuc(request.getRuc());
		proveedor.setCod_provee(request.getCod_provee());
		proveedor.setAccion(Accion.actualizar);
		System.out.println("Actualizar: {}" + proveedor);
		this.proveedorMapper.actualizarProveedor(proveedor);
		
		response.setExito(proveedor.getExito());
		
		return response;
	}

	@Override
	public EliminarProveedorResponse eliminarProveedor(Integer id, 
			EliminarProveedorResponse response) 
	{
		Proveedor proveedor = new Proveedor();
		proveedor.setCod_provee(id);
		proveedor.setAccion(Accion.eliminar);
		System.out.println("Eliminar: {}" + proveedor);
		this.proveedorMapper.eliminarProveedor(proveedor);;
		
		response.setExito(proveedor.getExito());
		
		return response;
	}

	@Override
	public List<Proveedor> buscarPorId(Integer id) 
	{
		return null;
	}

}
