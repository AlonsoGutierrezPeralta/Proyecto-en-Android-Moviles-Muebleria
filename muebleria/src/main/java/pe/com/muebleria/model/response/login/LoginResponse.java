package pe.com.muebleria.model.response.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
public class LoginResponse extends BaseResponse
{
	@JsonProperty("EXITO")
	private String exito;
}
