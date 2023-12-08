package pe.com.muebleria.model.request.transaccion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BoletaRequest 
{
	@JsonProperty("CODIGO_CLIENTE")
	private String codCliente;
	
	@JsonProperty("DETALLE_BOLETA")
	private List<DetalleBoletaRequest> detalleBoleta;
}
