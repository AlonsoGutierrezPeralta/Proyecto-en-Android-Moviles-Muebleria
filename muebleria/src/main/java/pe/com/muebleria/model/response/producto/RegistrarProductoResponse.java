package pe.com.muebleria.model.response.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarProductoResponse 
{

	@JsonProperty("EXITO")
	private String exito;
}
