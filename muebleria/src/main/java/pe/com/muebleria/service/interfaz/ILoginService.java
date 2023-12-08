package pe.com.muebleria.service.interfaz;

import pe.com.muebleria.model.request.login.LoginRequest;
import pe.com.muebleria.model.response.login.LoginResponse;

public interface ILoginService 
{
	public LoginResponse loguear(LoginRequest request, LoginResponse response);
}
