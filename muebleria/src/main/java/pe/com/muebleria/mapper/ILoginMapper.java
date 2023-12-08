package pe.com.muebleria.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import pe.com.muebleria.model.base.Login;

@Mapper
public interface ILoginMapper 
{
	@Select(value = {"{ CALL USP_VALIDAR_ACCESO ("
			+ "#{usuario, jdbcType=VARCHAR, mode=IN},"
			+ "#{contrasenia, jdbcType=VARCHAR, mode=IN},"
			+ "#{exito, jdbcType=VARCHAR, mode=OUT}"
			+ ")}"})
	@Options(statementType = StatementType.CALLABLE)
	public void validarAcceso(Login login);
}
