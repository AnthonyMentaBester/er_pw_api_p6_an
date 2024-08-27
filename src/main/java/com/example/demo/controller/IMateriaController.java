package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.MateriaCompletoTO;
import com.example.demo.service.to.MateriaTO;

@Controller
@CrossOrigin
@RequestMapping(path = "/materias")
public class IMateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaCompletoTO> guardar(@RequestBody MateriaCompletoTO materiaCompletoTO){
		this.iMateriaService.guardar(materiaCompletoTO);
		return ResponseEntity.status(HttpStatus.OK).body(materiaCompletoTO);
	}
	
	@GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaCompletoTO> buscarPorCodigo(@PathVariable String codigo){
		return ResponseEntity.status(HttpStatus.OK).body(iMateriaService.buscarPorCodigo(codigo));	
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(iMateriaService.buscarTodos());
		
	}
	
	@PutMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaCompletoTO> actualizar(@RequestBody MateriaCompletoTO materiaCompletoTO, @PathVariable String codigo ){
		MateriaCompletoTO Materia = new MateriaCompletoTO();
		Materia = this.iMateriaService.buscarPorCodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(this.iMateriaService.actualizar(Materia));
	}
	
	@DeleteMapping(path = "/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> borrar(@PathVariable String codigo){
		return ResponseEntity.status(HttpStatus.OK).body("borrado con exito");
		
		
	}
	

	
}
