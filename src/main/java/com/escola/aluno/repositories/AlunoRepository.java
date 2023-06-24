package com.escola.aluno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.aluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	public Optional<Aluno> findByAluno(String aluno);

}
