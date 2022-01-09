package br.com.primeiroprojetospring.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.domain.Professor;
import br.com.primeiroprojetospring.service.AlunoService;
import br.com.primeiroprojetospring.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private ProfessorService professorService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Huguinho");
		alunoService.salvarAluno(aluno1);

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Zezinho");
		alunoService.salvarAluno(aluno2);

		Aluno aluno3 = new Aluno();
		aluno3.setNome("Luizinho");
		alunoService.salvarAluno(aluno3);

		List<Aluno> listaAluno = alunoService.buscarTodosAlunos();

		for (Aluno aluno : listaAluno) {
			System.out.println(aluno.getNome());
		}

		Professor professor1 = new Professor();
		professor1.setNome("Tio Patinhas");
		professorService.salvarProfessor(professor1);

		Professor professor2 = new Professor();
		professor2.setNome("Pato Donald");
		professorService.salvarProfessor(professor2);

		Professor professor3 = new Professor();
		professor3.setNome("Pateta");
		professorService.salvarProfessor(professor3);

		List<Professor> listaProfessor = professorService.buscarTodosProfessores();

		for (Professor professor : listaProfessor) {
			System.out.println(professor.getNome());

		}
	}
}
