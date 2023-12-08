package pe.com.muebleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.muebleria.model.request.transaccion.BoletaRequest;
import pe.com.muebleria.model.response.transaccion.BoletaResponse;
import pe.com.muebleria.service.interfaz.IBoletaService;

@RestController
@RequestMapping("/api/muebleria/boleta")
public class BoletaController 
{
	private @Autowired IBoletaService boletaService;
	
	@PostMapping("/compra")
	public BoletaResponse compraEnLinea(@RequestBody BoletaRequest request)
	{
		BoletaResponse response = new BoletaResponse();
		
		response = this.boletaService.compraEnLinea(request, response);
		
		return response;
	}
}
