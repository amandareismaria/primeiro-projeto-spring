package br.com.primeiroprojetospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.primeiroprojetospring.domain.Aluno;
import br.com.primeiroprojetospring.service.AlunoService;

@Controller
@RequestMapping("aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/listarAlunos")
	public ModelAndView listaTodosAlunos() {
		ModelAndView mView = new ModelAndView("aluno/paginaListaAlunos");// pagina HTML
		mView.addObject("alunos", alunoService.buscarTodosAlunos());
		return mView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mView= new ModelAndView("aluno/cadastraAluno");
		mView.addObject("aluno", new Aluno());
		return mView;
	}
	
	@GetMapping("/salvar")
	public ModelAndView salvarAluno(Aluno aluno) {
		alunoService.salvarAluno(aluno);
		return listaTodosAlunos();
		
	}
}
