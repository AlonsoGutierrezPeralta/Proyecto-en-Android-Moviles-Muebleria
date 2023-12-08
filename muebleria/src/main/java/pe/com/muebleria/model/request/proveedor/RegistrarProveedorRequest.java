package pe.com.muebleria.model.request.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrarProveedorRequest {

	@JsonProperty("RAZ_SOCIAL")
	private String raz_soc;
	
	@JsonProperty("RUC")
	private Integer ruc;
	
	@JsonProperty("CODIGO_PROVEEDOR")
	private Integer cod_provee;
	
}
