package pe.com.muebleria.model.request.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarClienteRequest 
{
	@JsonProperty("CODIGO_CLIENTE")
	private Integer cod_cliente;
}
