package com.unam.apipizzasspringboot.service;

import com.unam.apipizzasspringboot.dto.PizzaDTO;

import java.util.ArrayList;
import java.util.List;

public interface IPIzzaService {
    public List<PizzaDTO> getPizzasServ();
    public PizzaDTO getPizzaById(Long id);
    public boolean deletePizzaById(Long id);
}
