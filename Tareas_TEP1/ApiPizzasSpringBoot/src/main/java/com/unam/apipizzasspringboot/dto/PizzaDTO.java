package com.unam.apipizzasspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String tamanio;
    private double precio;
}
