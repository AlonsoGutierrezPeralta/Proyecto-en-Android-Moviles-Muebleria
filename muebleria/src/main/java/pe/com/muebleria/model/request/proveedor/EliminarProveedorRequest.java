package pe.com.muebleria.model.request.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarProveedorRequest {
	
	@JsonProperty("CODIGO_PROVEEDOR")
	private Integer cod_provee;
	
}
