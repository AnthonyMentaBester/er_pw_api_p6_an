package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaCompletoTO;
import com.example.demo.service.to.MateriaTO;

public interface IMateriaService {
	
	public void guardar(MateriaCompletoTO materiaCompletoTO);
	public MateriaCompletoTO buscarPorCodigo(String codigo);
	public MateriaCompletoTO actualizar(MateriaCompletoTO materiaCompletoTO);
	public List<MateriaTO> buscarTodos();
	public void eliminar(String codigo);
	
	

}
