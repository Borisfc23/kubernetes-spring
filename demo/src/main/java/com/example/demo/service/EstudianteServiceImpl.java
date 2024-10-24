package com.example.demo.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Estudiante searchById(Integer id) {
		return jdbcTemplate.execute((Connection conn) -> {
            try (CallableStatement cs = conn.prepareCall("{call sp_ObtenerEstudiantePorId(?)}")) 
            {
                cs.setInt(1, id);
                try (ResultSet rs = cs.executeQuery()) 
                {
                    if (rs.next()) 
                    {
                        return mapearEstudiante(rs); 
                    } 
                    else 
                    {
                        return null;
                    }
                }
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                return null;
            }
        });
	}
	public Estudiante mapearEstudiante(ResultSet rs) throws SQLException {
		Estudiante estudiante = new Estudiante();
		estudiante.setId(rs.getInt("id"));
        estudiante.setNombre(rs.getString("nombre"));
        estudiante.setApellido(rs.getString("apellido"));
        estudiante.setCorreo(rs.getString("correo"));		
        return estudiante;
    }

	@Override
	public String crearEstudiante(Estudiante estudiante) {
		return jdbcTemplate.execute((Connection conn) -> {
			try (CallableStatement cs = conn.prepareCall("{call sp_CrearEstudiante(?,?,?)}")) 
			{
				cs.setString(1, estudiante.getNombre());
				cs.setString(2, estudiante.getApellido());
				cs.setString(3, estudiante.getCorreo());				
				cs.execute();
				
				return "Estudiante creado con exito";
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
		});
	}

	@Override
	public List<Estudiante> mostrarEstudiante() {
		return jdbcTemplate.execute((Connection conn) -> {
			try (CallableStatement cs = conn.prepareCall("{call sp_ObtenerEstudiantes()}")) {
				cs.execute();
				try (ResultSet rs = cs.getResultSet()) {
					List<Estudiante> estudiantes = new ArrayList<>();
					while (rs.next()) {
						Estudiante obj = new Estudiante();
						obj.setId(rs.getInt("id"));
						obj.setNombre(rs.getString("nombre"));
						obj.setApellido(rs.getString("apellido"));
						obj.setCorreo(rs.getString("correo"));						
						estudiantes.add(obj);
					}
					return estudiantes;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		});
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return jdbcTemplate.execute((Connection conn) -> {
			try (CallableStatement cs = conn.prepareCall("{call sp_ActualizarEstudiante(?,?,?,?)}")) 
			{
				cs.setInt(1, estudiante.getId());
				cs.setString(2, estudiante.getNombre());
				cs.setString(3, estudiante.getApellido());
				cs.setString(4, estudiante.getCorreo());				
				cs.execute();
				
				return estudiante;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
		});
	}

	@Override
	public String eliminarEstudiante(Integer id) {
		return jdbcTemplate.execute((Connection conn) -> {
            try (CallableStatement cs = conn.prepareCall("{call sp_EliminarEstudiante(?)}")) 
            {
                cs.setInt(1, id);
                cs.execute();
				return "Estudiante eliminado con exito";

            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                return null;
            }
        });
		
	}

}
