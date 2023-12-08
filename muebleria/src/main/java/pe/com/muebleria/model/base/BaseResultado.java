package pe.com.muebleria.model.base;

import lombok.Builder;
import lombok.Data;

@Data
public class BaseResultado 
{
	private String accion;
	
	private String exito;
	
	private String error;
}
