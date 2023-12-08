package pe.com.muebleria.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.muebleria.mapper.IBoletaMapper;
import pe.com.muebleria.model.base.Boleta;
import pe.com.muebleria.model.base.DetalleBoleta;
import pe.com.muebleria.model.request.transaccion.BoletaRequest;
import pe.com.muebleria.model.response.transaccion.BoletaResponse;
import pe.com.muebleria.service.interfaz.IBoletaService;

@Service
public class BoletaService implements IBoletaService
{
	private @Autowired IBoletaMapper boletaMapper;
	
	@Override
	@Transactional
	public BoletaResponse compraEnLinea(BoletaRequest request, BoletaResponse response) 
	{
		//Creando la cabezera
		
		Boleta boleta = new Boleta();
		boleta.setCodCliente(request.getCodCliente());
		this.boletaMapper.crearCabezeraBoleta(boleta);
		
		//Registrando los detalles
		List<DetalleBoleta> detalleBoletas = new ArrayList<>();
		
		request.getDetalleBoleta().stream().forEach(s -> 
				detalleBoletas.add(DetalleBoleta.builder()
						.numBoleta(boleta.getNumBoleta())
						.codProducto(s.getCodProducto())
						.cantidad(s.getCantidad())
						.precio(s.getPreciovta() * s.getCantidad())
						.build())
				);
		//Registrando el Detalle
		response.setNumBoleta(boleta.getNumBoleta());
		for (DetalleBoleta detBol : detalleBoletas) 
		{
			this.boletaMapper.ingresarDetalleBoleta(detBol);
			response.setExito(detBol.getExito());
		}
		
		return response;
	}

}
