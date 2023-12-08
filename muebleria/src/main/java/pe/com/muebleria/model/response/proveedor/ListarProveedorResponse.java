package pe.com.muebleria.model.response.proveedor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
@Builder
public class ListarProveedorResponse extends BaseResponse
{

	@JsonProperty("LISTADO_PROVEEDOR")
	private List<ProveedorResponse> listarProveedor;
	
}
