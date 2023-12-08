package pe.com.muebleria.model.response.transaccion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
public class BoletaResponse extends BaseResponse
{
	@JsonProperty("NUMERO_BOLETA")
	private String numBoleta;
	
	@JsonProperty("FECHA_BOLETA")
	private String fechaBoleta;
}
