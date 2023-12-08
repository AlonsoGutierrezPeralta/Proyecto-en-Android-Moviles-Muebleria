package pe.com.muebleria.model.response.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse 
{
	
	@JsonProperty("NOMBRE")
	private String nombre;
	
	@JsonProperty("APELLIDO")
	private String apellido;
	
	@JsonProperty("CODIGO_CLIENTE")
	private String cod_cliente;
	
}

