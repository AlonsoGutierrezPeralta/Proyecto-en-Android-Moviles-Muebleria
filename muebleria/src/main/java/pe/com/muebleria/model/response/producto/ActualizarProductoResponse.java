package pe.com.muebleria.model.response.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActualizarProductoResponse
{
	@JsonProperty("EXITO")
	private String exito;
}
