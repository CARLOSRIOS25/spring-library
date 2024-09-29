package com.spring.apps_empresariales.component;

import com.spring.apps_empresariales.model.Admin;
import com.spring.apps_empresariales.model.Author;
import com.spring.apps_empresariales.model.Book;
import com.spring.apps_empresariales.model.User;
import com.spring.apps_empresariales.repository.AdminRepository;
import com.spring.apps_empresariales.repository.AuthorRepository;
import com.spring.apps_empresariales.repository.UserRepository;
import com.spring.apps_empresariales.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar un usuario admin
        Admin admin = new Admin();
        admin.setNombre("admin");
        admin.setNum_celular(123123L);

        // Guardar el admin primero para obtener su ID
        adminRepository.save(admin);

        User userAdmin = new User();
        userAdmin.setNombre(admin.getNombre());
        userAdmin.setNum_celular(admin.getNum_celular());
        userAdmin.setUsername("admin");
        userAdmin.setPassword("admin123");
        userAdmin.setAdmin(admin); // Establecer la relación con el admin

        // Guardar el usuario admin
        userRepository.save(userAdmin);

        // Crear y guardar un segundo usuario
        User user = new User();
        user.setNombre("user");
        user.setNum_celular(456456L);
        user.setUsername("user");
        user.setPassword("user123");

        // Guardar el segundo usuario
        userRepository.save(user);

        Author author1 = new Author();
        author1.setName("Autor 1");

        Author author2 = new Author();
        author2.setName("Autor 2");

        Author author3 = new Author();
        author3.setName("Autor 3");

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        // Crear y guardar tres libros
        Book book1 = new Book();
        book1.setTitle("Libro 1");
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setTitle("Libro 2");
        book2.setAuthor(author2);

        Book book3 = new Book();
        book3.setTitle("Libro 3");
        book3.setAuthor(author3);

        // Guardar los libros
        bookService.saveBook(book1);
        bookService.saveBook(book2);
        bookService.saveBook(book3);
    }
}
