package br.com.primeiroprojetospring.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private EntityManager entityManager;
	
	public List<Aluno> buscarTodosAlunos() {
		
		return alunoRepository.findAll();
	}

	public Aluno salvarAluno(Aluno aluno) {
		
		return alunoRepository.save(aluno);
	}

}
