package pe.com.muebleria.model.response.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActualizarClienteResponse
{
	@JsonProperty("EXITO")
	private String exito;
}
