package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	
	public void insertar(Materia materia);
	public Materia seleccionarPorCodigo(String codigo);
	public Materia actualizar(Materia materia);
	public List<Materia> seleccionarTodos();
	public void eliminar(String codigo);
	

}
