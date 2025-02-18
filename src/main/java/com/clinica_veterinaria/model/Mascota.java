package com.clinica_veterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_masco;
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @OneToOne
    @JoinColumn(name = "id_duenio", referencedColumnName = "id_duenio")
    private Duenio unDuenio;

    public Mascota(Long id_masco, String nombre, String especie, String raza, String color) {
        this.id_masco = id_masco;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }

    public Mascota() {
    }
}
