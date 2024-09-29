package com.spring.apps_empresariales.controller;

import com.spring.apps_empresariales.model.Author;
import com.spring.apps_empresariales.model.Book;
import com.spring.apps_empresariales.model.User;
import com.spring.apps_empresariales.repository.AuthorRepository;
import com.spring.apps_empresariales.service.AuthorService;
import com.spring.apps_empresariales.service.BookService;
import com.spring.apps_empresariales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/addBook")
    public String registrarLibro(@RequestParam String title, @RequestParam String authorName) {

        //seteamos el titulo del libro
        Book book = new Book();
        book.setTitle(title);

        //buscamos el autor por nombre
        Author author = authorService.autorPorNombre(authorName);
        //si no existe, lo creamos
        if (author == null) {
            author = new Author();
            author.setName(authorName);
            authorRepository.save(author);
        }
        //seteamos el autor del libro
        book.setAuthor(author);

        //guardamos el libro
        bookService.saveBook(book);
        return "redirect:/admin";
    }

    @PostMapping("/prestar")
    public String prestarLibro(@RequestParam  Long id, @RequestParam String username){
        Book book = bookService.buscarLibro(id);
        User user = userService.findByUsername(username);
        if (book != null && user != null){
            //agregamos el usuario a la lista de prestatarios de ese libro
            book.getPrestatarios().add(user);
            bookService.saveBook(book);
        }
        return "redirect:/libros/all";
    }

    @GetMapping("/all")
    public String obtenerLibros(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "listarLibros";
    }

    @GetMapping("/{id}")
    public Book obtenerLibroPorId(@PathVariable Long id) {
        return bookService.buscarLibro(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
