package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaCompletoTO;
import com.example.demo.service.to.MateriaTO;

@Service
public class IMateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;

	public MateriaCompletoTO cast(Materia materia) {
		MateriaCompletoTO to = new MateriaCompletoTO();
		to.setCodigo(materia.getCodigo());
		to.setDescripcion(materia.getDescripcion());
		to.setId(materia.getId());
		to.setNombre(materia.getNombre());
		to.setNumCreditos(materia.getNumCreditos());
		return to;
	}

	public MateriaTO castModeloTo(Materia materia) {
		MateriaTO to = new MateriaTO();
		to.setCodigo(materia.getCodigo());
		to.setNombre(materia.getNombre());
		return to;

	}

	public Materia castModelo(MateriaCompletoTO materiaCompletoTO) {
		Materia obj = new Materia();
		obj.setCodigo(materiaCompletoTO.getCodigo());
		obj.setDescripcion(materiaCompletoTO.getDescripcion());
		obj.setId(materiaCompletoTO.getId());
		obj.setNombre(materiaCompletoTO.getNombre());
		obj.setNumCreditos(materiaCompletoTO.getNumCreditos());
		return obj;

	}

	@Override
	public void guardar(MateriaCompletoTO materiaCompletoTO) {
		this.iMateriaRepository.insertar(castModelo(materiaCompletoTO));

	}

	@Override
	public MateriaCompletoTO buscarPorCodigo(String codigo) {
		return this.cast(this.iMateriaRepository.seleccionarPorCodigo(codigo));
	}

	@Override
	public MateriaCompletoTO actualizar(MateriaCompletoTO materiaCompletoTO) {
		
		this.iMateriaRepository.actualizar(castModelo(materiaCompletoTO));
		return materiaCompletoTO;
	}

	@Override
	public List<MateriaTO> buscarTodos() {
		 List<Materia> lista = this.iMateriaRepository.seleccionarTodos();
		
		 List<MateriaTO> listTO = new ArrayList<>();
		for (Materia materia : lista) {
			lista.add(materia);
		}
		
		return listTO;
	}

	@Override
	public void eliminar(String codigo) {
		cast(this.iMateriaRepository.seleccionarPorCodigo(codigo));
	}

}
