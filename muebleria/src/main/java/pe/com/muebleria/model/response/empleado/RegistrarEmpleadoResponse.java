package pe.com.muebleria.model.response.empleado;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarEmpleadoResponse {

	@JsonProperty("EXITO")
	private String exito;
	
}
