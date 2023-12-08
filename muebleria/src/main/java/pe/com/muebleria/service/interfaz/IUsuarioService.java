package pe.com.muebleria.service.interfaz;

import pe.com.muebleria.model.request.producto.RegistrarProductoRequest;
import pe.com.muebleria.model.request.usuario.RegistrarUsuarioRequest;
import pe.com.muebleria.model.response.usuario.RegistrarUsuarioResponse;

public interface IUsuarioService
{
	public RegistrarUsuarioResponse registrarUsuario(RegistrarUsuarioRequest request, RegistrarUsuarioResponse response);
}
