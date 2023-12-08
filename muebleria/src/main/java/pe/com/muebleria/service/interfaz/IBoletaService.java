package pe.com.muebleria.service.interfaz;

import pe.com.muebleria.model.request.transaccion.BoletaRequest;
import pe.com.muebleria.model.response.transaccion.BoletaResponse;

public interface IBoletaService 
{
	public BoletaResponse compraEnLinea(BoletaRequest request, BoletaResponse response);
}
