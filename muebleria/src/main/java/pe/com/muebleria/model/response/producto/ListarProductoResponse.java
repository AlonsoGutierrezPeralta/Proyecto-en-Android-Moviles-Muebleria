package pe.com.muebleria.model.response.producto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import pe.com.muebleria.model.baseresponse.BaseResponse;

@Data
@Builder
public class ListarProductoResponse extends BaseResponse
{
	@JsonProperty("LISTADO_PRODUCTOS")
	private List<ProductoResponse> listarProductos;
}
