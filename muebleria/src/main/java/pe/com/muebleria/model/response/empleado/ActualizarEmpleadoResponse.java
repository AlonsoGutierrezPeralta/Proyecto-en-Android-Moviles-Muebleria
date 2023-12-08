package pe.com.muebleria.model.response.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActualizarEmpleadoResponse {

	@JsonProperty("EXITO")
	private String exito;
}
