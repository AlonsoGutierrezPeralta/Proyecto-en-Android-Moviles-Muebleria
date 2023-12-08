package pe.com.muebleria.model.request.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrarClienteRequest 
{
	@JsonProperty("CODIGO_CLIENTE")
	private String codigo;
	
	@JsonProperty("NOMBRE")
	private String nombre;
	
	@JsonProperty("APELLIDO")
	private String apellido;
	
}

