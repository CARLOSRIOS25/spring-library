package com.spring.apps_empresariales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long num_celular;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @ManyToMany(mappedBy = "prestatarios")
    private List<Book> librosPrestados;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}