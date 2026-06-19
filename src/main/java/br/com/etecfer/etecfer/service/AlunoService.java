package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Aluno;
import br.com.etecfer.etecfer.repository.AlunoRepository;

@Service
public class AlunoService {

    // Injeção de dependência do repositório para a classe aluno
    @Autowired
    private AlunoRepository alunoRepository;

    //Método para salvar um aluno
    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    //Método para listar todos os alunos
    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }
    
    //Método para excluir um aluno pelo ID
    public void deleteById(Integer id){
        alunoRepository.deleteById(id);
    }

    //Método para buscar um aluno pelo ID
    public Aluno findById(Integer id){
        return alunoRepository.findById(id).orElse(null);
    }
    
}
