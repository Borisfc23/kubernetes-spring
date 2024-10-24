package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Estudiante;
import com.example.demo.service.EstudianteServiceImpl;

@Service
public class EstudianteRepository {
	
	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;
	
	public Estudiante searchById(Integer id) {
		return estudianteServiceImpl.searchById(id);
	}
	
	public String crearEstudiante(Estudiante estudiante) {
		return estudianteServiceImpl.crearEstudiante(estudiante);
	}
	
	public List<Estudiante> mostrarEstudiantes() {
		return estudianteServiceImpl.mostrarEstudiante();
	}
	
	public Estudiante actualizarEstudiante(Estudiante Estudiante) {
		return estudianteServiceImpl.actualizarEstudiante(Estudiante);
	}
	
	public String eliminarEstudiante(Integer id) {
		return estudianteServiceImpl.eliminarEstudiante(id);
	}
}
