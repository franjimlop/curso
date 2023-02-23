package com.cursojava.curso.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "usuarios")
//Indica que es una entidad JPA y se mapea a una tabla en la BB.DD. (usuarios)
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Usuario {
    //Indica que la variable id es la clave primaria
    @Id
    //Genera automáticamente el valor de la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String apellido;
    String email;
    String telefono;
    //Los @Column se utilizan para mapear los campos de la tabla a los atributos de Usuario
    @Column(name = "password")
    private String password;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return id != null && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
