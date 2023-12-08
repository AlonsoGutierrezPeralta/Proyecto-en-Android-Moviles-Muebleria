package pe.com.muebleria.model.request.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActualizarProductoRequest
{
	@JsonProperty("CODIGO_PRODUCTO")
	private Integer codigoProducto;
	
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
