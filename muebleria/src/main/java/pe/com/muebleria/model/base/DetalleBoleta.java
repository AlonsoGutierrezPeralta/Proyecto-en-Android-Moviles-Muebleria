package pe.com.muebleria.model.base;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalleBoleta
{
	private String numBoleta;
	
	private String codProducto;
	
	private Integer cantidad;
	
	private Double precio;
	
	private String exito;
}
