package pe.com.muebleria.model.response.proveedor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProveedorResponse 
{
	
	@JsonProperty("RAZ_SOCIAL")
	private String raz_soc;
	
	@JsonProperty("RUC")
	private Integer ruc;
	
	@JsonProperty("CODIGO_PROVEEDOR")
	private Integer cod_provee;
	
}
