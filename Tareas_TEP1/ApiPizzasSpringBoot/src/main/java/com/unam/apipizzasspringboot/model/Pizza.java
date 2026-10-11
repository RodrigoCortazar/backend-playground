package com.unam.apipizzasspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pizza {
    private Long id;
    private String nombre;
    private String descripcion;
    private Tamanio tamanio;
    private double precio;
}
