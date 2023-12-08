package pe.com.muebleria.model.response.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoResponse {
	@JsonProperty("CODIGO_EMPLEADO")
	private Integer codigo;
	@JsonProperty("NOMBRE")
	private String nombre;
	@JsonProperty("APELLIDO")
	private String apellido;
	@JsonProperty("PUESTO")
	private Integer puesto;
}
