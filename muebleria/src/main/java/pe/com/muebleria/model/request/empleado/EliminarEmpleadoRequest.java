package pe.com.muebleria.model.request.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EliminarEmpleadoRequest {
	@JsonProperty("CODIGO_EMPLEADO")
	private Integer codigo;
}
