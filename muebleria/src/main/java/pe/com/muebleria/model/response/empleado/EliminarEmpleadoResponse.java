package pe.com.muebleria.model.response.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarEmpleadoResponse {
	
	@JsonProperty("EXITO")
	private String exito;
}
