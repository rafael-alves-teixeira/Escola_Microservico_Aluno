package com.escola.aluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.aluno.entities.Aluno;
import com.escola.aluno.repositories.AlunoRepository;

@Service
public class AlunoService {
	

	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public List<Aluno> findAll() {
		List<Aluno> alunos = alunoRepository.findAll();
		return alunos;

	}
	
	public Optional<Aluno> findById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno;
	}

	public Optional<Aluno> cadastrarAluno(Aluno aluno) {
		
		if(alunoRepository.findByAluno(aluno.getAluno()).isPresent()) {
			return Optional.empty();
	}
		
		return Optional.of(alunoRepository.save(aluno));		
	}

	public Optional<Aluno> atualizarAluno(Aluno aluno) {
		
		if(alunoRepository.findById(aluno.getId()).isPresent()) {
			
			if(alunoRepository.findByAluno(aluno.getAluno()).isPresent()) {
				return Optional.empty();
		}
						
			return Optional.ofNullable(alunoRepository.save(aluno));
		}
		
		return Optional.empty();
	}
	

	public void deleteById(Long id) {
		
		if(alunoRepository.findById(id).isPresent()) {	
			
			alunoRepository.deleteById(id);
		}		
	}

	
}
