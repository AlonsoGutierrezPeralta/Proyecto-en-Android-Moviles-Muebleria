package pe.com.muebleria.service.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.muebleria.mapper.IUsuarioMapper;
import pe.com.muebleria.model.base.Usuario;
import pe.com.muebleria.model.request.usuario.RegistrarUsuarioRequest;
import pe.com.muebleria.model.response.usuario.RegistrarUsuarioResponse;
import pe.com.muebleria.parametros.Accion;
import pe.com.muebleria.service.interfaz.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService
{
	
	private @Autowired IUsuarioMapper usuarioMapper;

	@Override
	public RegistrarUsuarioResponse registrarUsuario(RegistrarUsuarioRequest request,
			RegistrarUsuarioResponse response) 
	{
		Usuario usuario = new Usuario();
		
		usuario.setAccion(Accion.registrar);
		usuario.setUsuario(request.getUsuario());
		usuario.setClave(request.getContrasenia());
		
		System.out.println("Registrar Usuario {} " + usuario);
		this.usuarioMapper.mantenimiento(usuario);
		
		response.setExito(usuario.getExito());
		return response;
	}
	
}
