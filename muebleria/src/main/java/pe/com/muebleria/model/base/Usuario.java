package pe.com.muebleria.model.base;

import lombok.Data;

@Data
public class Usuario extends BaseResultado
{
	private int codigo;
	
	private String usuario;
	
	private String clave;
	
	private int tipo;
}
