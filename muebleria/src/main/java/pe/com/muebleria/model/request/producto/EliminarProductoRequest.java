package pe.com.muebleria.model.request.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarProductoRequest 
{
	@JsonProperty("CODIGO_PRODUCTO")
	private Integer codigoProducto;
}
