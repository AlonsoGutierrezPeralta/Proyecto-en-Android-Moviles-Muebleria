package pe.com.muebleria.model.request.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class LoginRequest 
{
	@JsonProperty("USUARIO")
	private String usuario;
	
	@JsonProperty("CONTRASENIA")
	private String contrasenia;
	
}
