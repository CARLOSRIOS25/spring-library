package com.spring.apps_empresariales.service;

import com.spring.apps_empresariales.model.Author;
import com.spring.apps_empresariales.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public Author autorPorNombre(String name)
    {
        return authorRepository.findByName(name);
    }
}
