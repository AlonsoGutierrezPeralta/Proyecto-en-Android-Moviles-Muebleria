package pe.com.muebleria.model.request.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActualizarClienteRequest
{
	@JsonProperty("CODIGO_CLIENTE")
	private Integer cod_cliente;
	
	@JsonProperty("NOMBRE")
	private String nombre;
	
	@JsonProperty("APELLIDO")
	private String apellido;
	
}