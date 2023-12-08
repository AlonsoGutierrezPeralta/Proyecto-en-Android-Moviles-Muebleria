package pe.com.muebleria.model.request.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActualizarEmpleadoRequest {
	
	@JsonProperty("CODIGO_EMPLEADO")
	private Integer codigo;
	@JsonProperty("NOMBRE")
	private String nombre;
	@JsonProperty("APELLIDO")
	private String apellido;
	@JsonProperty("PUESTO")
	private Integer puesto;
}
