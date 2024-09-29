package com.spring.apps_empresariales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@Entity
@Table(name="admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String nombre;
    private Long num_celular;

    @OneToMany(mappedBy = "admin")
    private List<User> usuarios;
}
