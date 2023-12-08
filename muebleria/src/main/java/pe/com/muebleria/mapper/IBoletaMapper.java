package pe.com.muebleria.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import pe.com.muebleria.model.base.Boleta;
import pe.com.muebleria.model.base.DetalleBoleta;

@Mapper
public interface IBoletaMapper 
{
	@Select("{CALL USP_CREAR_CABEZERA_BOLETA("
			+ "#{codCliente, jdbcType=INTEGER, mode=IN},"
			+ "#{numBoleta, jdbcType=VARCHAR, mode=OUT}"
			+ ")}")
	@Options(statementType =  StatementType.CALLABLE)
	public void crearCabezeraBoleta(Boleta boleta);
	
	@Select("{CALL USP_REGISTRAR_DETALLE_BOLETA("
			+ "#{numBoleta, jdbcType=VARCHAR, mode=IN},"
			+ "#{codProducto, jdbcType=INTEGER, mode=IN},"
			+ "#{cantidad, jdbcType=INTEGER, mode=IN},"
			+ "#{precio, jdbcType=DOUBLE, mode=IN},"
			+ "#{exito, jdbcType=VARCHAR, mode=OUT}"
			+ ")}")
	@Options(statementType =  StatementType.CALLABLE)
	public void ingresarDetalleBoleta(DetalleBoleta detalleBoleta);
}
