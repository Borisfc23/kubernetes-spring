package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Estudiante;
import com.example.demo.repo.EstudianteRepository;

@RestController
@RequestMapping("/api/test")
public class EstudianteController {
	@Autowired
	private EstudianteRepository  estudianteRepository;
	
	
	
	@GetMapping("/listar")		
	public List<Estudiante> listarEstudiantes() {
		return estudianteRepository.mostrarEstudiantes();
	}
	@GetMapping("/{id}")	
	public Estudiante obtenerEstudiantePorId(@PathVariable Integer id) {
		return estudianteRepository.searchById(id);
	}
	
	@PostMapping("/registrar")	
	public String registrarEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteRepository.crearEstudiante(estudiante);
	}
	
	@PutMapping("/actualizar")	
	public Estudiante actualizarEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteRepository.actualizarEstudiante(estudiante);
	}
	@DeleteMapping("/{id}")	
	public String eliminarEstudiante(@PathVariable Integer id) {
		return estudianteRepository.eliminarEstudiante(id);
	}
}
