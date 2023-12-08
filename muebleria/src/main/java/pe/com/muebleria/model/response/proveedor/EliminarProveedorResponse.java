package pe.com.muebleria.model.response.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarProveedorResponse {

	@JsonProperty("EXITO")
	private String exito;
	
}
