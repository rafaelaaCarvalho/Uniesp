package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
        @Autowired
        ProfessorService professorService;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<Professor> create(@RequestBody Professor professor) {

            Professor professorCreated = professorService.create(professor);

            return ResponseEntity.status(201).body(professor);
        }

        @GetMapping("/professor-todos")
        @ResponseStatus(HttpStatus.OK)
        public List<Professor> findall() {

            return professorService.findAll();
        }

        @GetMapping("/{id}")
        @ResponseStatus(HttpStatus.OK)
        public Optional<Professor> findById(@PathVariable Long id) {

            return professorService.findByID(id);
        }

        @PutMapping("update-professor/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateUser(@RequestBody Professor user, @PathVariable Long id) {

            professorService.putProfessor(id, user);
        }


        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id) {
            professorService.deleteByID(id);
        }
}
