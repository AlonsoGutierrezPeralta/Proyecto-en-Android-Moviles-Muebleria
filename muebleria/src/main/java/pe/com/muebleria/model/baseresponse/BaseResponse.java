package pe.com.muebleria.model.baseresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BaseResponse 
{
	@JsonProperty("EXITO")
	private String exito;
}
