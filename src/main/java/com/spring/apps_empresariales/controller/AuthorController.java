package com.spring.apps_empresariales.controller;

import com.spring.apps_empresariales.model.Author;
import com.spring.apps_empresariales.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/addAuthor")
    public void registrarAutor(@RequestBody @Valid Author author) {
        authorRepository.save(author);
    }

    @GetMapping
    public List<Author> obtenerAutores() {
        return authorRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }

}
