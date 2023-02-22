package com.cursojava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "usuarios")
//Indica que es una entidad JPA y se mapea a una tabla en la BB.DD. (usuarios)
@Entity
@ToString @EqualsAndHashCode
public class Usuario {
    //Indica que la variable id es la clave primaria
    @Id
    //Genera automáticamente el valor de la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Los @Column se utilizan para mapear los campos de la tabla a los atributos de Usuario
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "apellido")
    private String apellido;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "telefono")
    private String telefono;
    @Getter @Setter @Column(name = "password")
    private String password;

}
