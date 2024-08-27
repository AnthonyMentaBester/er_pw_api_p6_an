package com.example.demo.service.to;

import java.io.Serializable;

import jakarta.persistence.Column;

public class MateriaCompletoTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private Integer id;

	private String codigo;
	
	private String nombre;
	
	private String descripcion;
	
	private Integer numCreditos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(Integer numCreditos) {
		this.numCreditos = numCreditos;
	}
	
	

}
