package pe.com.muebleria.model.request.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegistrarUsuarioRequest 
{
	@JsonProperty("USUARIO")
	private String usuario;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("CONTRASENIA")
	private String contrasenia;
}
