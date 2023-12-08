package pe.com.muebleria.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Proveedor extends BaseResultado{
	
	private String raz_soc;
	
	private Integer ruc;
	
	private Integer cod_provee;
	
}
