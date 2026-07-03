package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.service.DisciplinaService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    //Injeção de dependência da service para a classe professor
   @Autowired
   private DisciplinaService disciplinaService;

   //Método para salvar um professor
   @PostMapping("/salvar")
   public String salvar(@ModelAttribute Disciplina disciplina) {
        disciplinaService.save(disciplina);
       return "redirect:/disciplinas/listar";
   }
   
   //Método para listar todas as disciplinas
   @GetMapping("/listar")
    public String listar(Model model) {
        List<Disciplina> disciplinas = disciplinaService.findAll();
        return "disciplina/listarDisciplinas";
    }
   
   //Método para criar um formulário com um novo objeto disciplina
   @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "professor/formularioProfessor";
    }
   
   //Método para excluir uma disciplina
   @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        disciplinaService.deleteById(id);
        return "redirect:/disciplinas/listar";
    }
   
   //Método para abrir o formulário de edição de disciplinas
   @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Disciplina disciplina = disciplinaService.findById(id);
        model.addAttribute("disciplina", disciplina);
        return "disciplina/formularioDisciplina";
    }

}