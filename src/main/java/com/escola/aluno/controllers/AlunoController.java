package com.escola.aluno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.escola.aluno.entities.Aluno;
import com.escola.aluno.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Aluno>>  findAll() {
		
		return ResponseEntity.ok(alunoService.findAll()); 		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable  Long id){
		return alunoService.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Aluno> post(@Valid @RequestBody Aluno aluno){
		return alunoService.cadastrarAluno(aluno)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());	
	} 
	
	@PutMapping("/atualizar")
	public ResponseEntity<Aluno> putAluno(@Valid @RequestBody Aluno aluno) {
		
		return alunoService.atualizarAluno(aluno)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Aluno> aluno= alunoService.findById(id);
		
		if(aluno.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		alunoService.deleteById(id);
	}	
	
	
	
	
	
	
	
	
}
