package pe.com.muebleria.model.response.empleado;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
@Builder
public class ListarEmpleadoResponse {
	@JsonProperty("LISTADO_EMPLEADO")
	private List <EmpleadoResponse> listarEmpleado;
	
	@JsonProperty("EXITO")
	private String exito;

}
