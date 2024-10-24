package com.example.demo.service;

import java.util.List;

import com.example.demo.beans.Estudiante;

public interface  EstudianteService {
	public Estudiante searchById(Integer id);
	public String crearEstudiante(Estudiante estudiante);
	public List<Estudiante> mostrarEstudiante();
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	public String eliminarEstudiante(Integer id);
}
