package pe.com.muebleria.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empleado extends BaseResultado {
	
	private Integer codigo;
	
	private String nombre;
	
	private String apellido;
	
	private Integer puesto;
	
}
