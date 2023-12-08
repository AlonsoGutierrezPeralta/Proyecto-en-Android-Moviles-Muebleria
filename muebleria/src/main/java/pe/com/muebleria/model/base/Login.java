package pe.com.muebleria.model.base;

import lombok.Data;

@Data
public class Login extends BaseResultado
{
	private String usuario;
	
	private String contrasenia;
}
