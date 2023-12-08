package pe.com.muebleria.model.request.transaccion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DetalleBoletaRequest 
{	
	@JsonProperty("CODIGO_PRODUCTO")
	private String codProducto;
	
	@JsonProperty("CANTIDAD")
	private Integer cantidad;
	
	@JsonProperty("PRECIO")
	private Double preciovta;
}
