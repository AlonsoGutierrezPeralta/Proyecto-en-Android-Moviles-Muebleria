package pe.com.muebleria.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import pe.com.muebleria.model.base.Usuario;

@Mapper
public interface IUsuarioMapper 
{
	@Select(value = {"{ CALL USP_MANTENIMIENTO_USUARIO ("
			+ "#{codigo, jdbcType=INTEGER, mode=IN},"
			+ "#{usuario, jdbcType=VARCHAR, mode=IN},"
			+ "#{clave, jdbcType=VARCHAR, mode=IN},"
			+ "#{accion, jdbcType=VARCHAR, mode=IN},"
			+ "#{exito, jdbcType=VARCHAR, mode=OUT}"
			+ ")}"})
	@Options(statementType =  StatementType.CALLABLE)
	public void mantenimiento(Usuario usuario);
}
