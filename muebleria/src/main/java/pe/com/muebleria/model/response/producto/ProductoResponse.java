package pe.com.muebleria.model.response.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
@Builder
public class ProductoResponse 
{
	@JsonProperty("CODIGO_PRODUCTO")
	private String codigoProducto;
	
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
