package pe.com.muebleria.service.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.muebleria.mapper.ILoginMapper;
import pe.com.muebleria.model.base.Login;
import pe.com.muebleria.model.request.login.LoginRequest;
import pe.com.muebleria.model.response.login.LoginResponse;
import pe.com.muebleria.service.interfaz.ILoginService;

@Service
public class LoginService implements ILoginService
{
	private @Autowired ILoginMapper loginMapper;
	
	
	@Override
	public LoginResponse loguear(LoginRequest request, LoginResponse response) 
	{
		Login login = new Login();
		
		login.setUsuario(request.getUsuario());
		login.setContrasenia(request.getContrasenia());
		
		System.out.println("LOGUEANDO: {} " + login);
		this.loginMapper.validarAcceso(login);
		
		response.setExito(login.getExito());
		
		return response;
	}

}
