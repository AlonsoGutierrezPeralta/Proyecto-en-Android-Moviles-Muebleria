package pe.com.muebleria.model.request.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrarEmpleadoRequest {
	@JsonProperty("CODIGO_EMPLEADO")
	private String codigo;
	@JsonProperty("NOMBRE")
	private String nombre;
	@JsonProperty("APELLIDO")
	private String apellido;
	@JsonProperty("PUESTO")
	private String puesto;
}
