package com.unam.apipizzasspringboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String tamanio;
    private double precio;
}
