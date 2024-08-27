package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class IMateriaRepositoryImp implements IMateriaRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia> query = this.entityManager
				.createNamedQuery("SELECT m FROM Materia m WHERE m.codigo = :codigo", Materia.class)
				.setParameter("codigo", codigo);

		return query.getSingleResult();
	}

	@Override
	public Materia actualizar(Materia materia) {
		
		return this.entityManager.merge(materia);
	}

	@Override
	public List<Materia> seleccionarTodos() {
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
		
		return query.getResultList();
	}

	@Override
	public void eliminar(String codigo) {
		this.entityManager.remove(this.seleccionarPorCodigo(codigo));
	}

}
