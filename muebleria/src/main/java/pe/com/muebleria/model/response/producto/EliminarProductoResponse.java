package pe.com.muebleria.model.response.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarProductoResponse
{
	@JsonProperty("EXITO")
	private String exito;
}
