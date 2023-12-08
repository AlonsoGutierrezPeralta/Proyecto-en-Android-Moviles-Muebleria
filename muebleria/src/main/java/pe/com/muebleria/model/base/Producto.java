package pe.com.muebleria.model.base;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto extends BaseResultado
{
	private Integer codigoProducto;
	
	private Integer codigoProveedor;
	
	private String descripcionProducto;
	
	private Integer idTipo;
	
	private Integer stock;
	
	private Double precio;
	
}
