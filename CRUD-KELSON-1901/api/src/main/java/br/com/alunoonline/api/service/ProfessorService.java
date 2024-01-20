package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create (Professor professor){
       return  repository.save(professor);
    }

    public List<Professor> findAll(){

       return repository.findAll();
    }
    public Optional<Professor> findByID(Long id) {
       return repository.findById(id);
    }
    public Professor putProfessor(Long id, Professor professorUpdate) {

        Optional<Professor> professorOptional = repository.findById(id);

        Professor updtate = professorOptional.get();

        updtate.setNome(professorUpdate.getNome());
        updtate.setEmail(professorUpdate.getEmail());
        updtate.setAreaDoConhecimento(professorUpdate.getAreaDoConhecimento());

        Professor updateProfessor = repository.save(updtate);
        return updateProfessor;
    }
    public void deleteByID(Long id){
        repository.deleteById(id);
    }
}
