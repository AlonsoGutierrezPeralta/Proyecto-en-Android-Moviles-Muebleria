package pe.com.muebleria.model.response.cliente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
@Builder
public class ListarClienteResponse
{
	@JsonProperty("LISTADO_CLIENTE")
	private List<ClienteResponse> listarCliente;
	
	@JsonProperty("EXITO")
	private String exito;
}
