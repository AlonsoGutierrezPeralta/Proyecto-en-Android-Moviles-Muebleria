package pe.com.muebleria.model.base;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente extends BaseResultado
{	
	private String nombre;
	
	private String apellido;
	
	private Integer cod_cliente;
	
}