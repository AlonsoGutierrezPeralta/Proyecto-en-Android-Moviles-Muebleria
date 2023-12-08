package pe.com.muebleria.model.request.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActualizarProveedorRequest {
	
	
	@JsonProperty("RAZ_SOCIAL")
	private String raz_soc;
	
	@JsonProperty("RUC")
	private Integer ruc;
	
	@JsonProperty("CODIGO_PROVEEDOR")
	private Integer cod_provee;
	
	
}
