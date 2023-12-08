package pe.com.muebleria.model.request.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrarProductoRequest 
{
	@JsonProperty("CODIGO_PROVEEDOR")
	private Integer codigoProveedor;
	
	@JsonProperty("DESCRIPCION")
	private String descripcionProducto;
	
	@JsonProperty("TIPO")
	private Integer idTipo;
	
	@JsonProperty("STOCK")
	private Integer stock;
	
	@JsonProperty("PRECIO")
	private Double precio;
}
