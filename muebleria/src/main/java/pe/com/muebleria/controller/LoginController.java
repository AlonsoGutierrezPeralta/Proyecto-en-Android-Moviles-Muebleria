package pe.com.muebleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.muebleria.model.request.login.LoginRequest;
import pe.com.muebleria.model.request.producto.RegistrarProductoRequest;
import pe.com.muebleria.model.request.usuario.RegistrarUsuarioRequest;
import pe.com.muebleria.model.response.login.LoginResponse;
import pe.com.muebleria.model.response.usuario.RegistrarUsuarioResponse;
import pe.com.muebleria.service.interfaz.ILoginService;
import pe.com.muebleria.service.interfaz.IUsuarioService;

@RestController
@RequestMapping("/api/muebleria/login")
public class LoginController 
{
	private @Autowired ILoginService loginService;
	private @Autowired IUsuarioService usuarioService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse loguear(@RequestBody LoginRequest request)
	{
		LoginResponse response = new LoginResponse();
		
		response = this.loginService.loguear(request, response);
		
		return response;
	}
	
	@PostMapping(value="/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public RegistrarUsuarioResponse registrar(@RequestBody RegistrarUsuarioRequest request)
	{
		RegistrarUsuarioResponse response = new RegistrarUsuarioResponse();
		
		response = this.usuarioService.registrarUsuario(request, response);
		
		return response;
	}
	
}
