package com.escola.aluno.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "É obrigatório informar o nome!")
	private String name;
	
	@NotNull(message = "É obrigatório informar a idade!")
	private Integer age;
	
	@Email(message = "Precisa informar um email válido!")
	@NotBlank(message = "É obrigatório informar o email!")
	private String aluno;
	
	@NotBlank(message = "É obrigatório o atributo 'telefone'!")
	@Size(min = 8, message = "O telefone deve ter no mínimo 8  caracteres!")
	private String telephone;
	
	@NotBlank(message = "É obrigatório o atributo 'cpf'!")
	@Size(min = 11, max = 14, message = "O CPF deve ter no mínimo 11 caracteres e no máximo 14, incluindo a formatação!")
	private String cpf;
	
	
	public Aluno() {
	}

	public Aluno(Long id, String name, Integer age, String aluno, String telephone, String cpf) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.aluno = aluno;
		this.telephone = telephone;
		this.cpf = cpf;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelefone(String telephone) {
		this.telephone = telephone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAluno() {
		return aluno;
	}

	public void setEmail(String aluno) {
		this.aluno = aluno;
	}
		

}
