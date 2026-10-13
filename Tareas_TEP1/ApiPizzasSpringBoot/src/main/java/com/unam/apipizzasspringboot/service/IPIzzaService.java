package com.unam.apipizzasspringboot.service;

import com.unam.apipizzasspringboot.dto.PizzaDTO;
import com.unam.apipizzasspringboot.model.Tamanio;

import java.util.ArrayList;
import java.util.List;

public interface IPIzzaService {
    public List<PizzaDTO> getPizzasServ();
    public PizzaDTO getPizzaById(Long id);
    public boolean deletePizzaById(Long id);
    public void createPizza(PizzaDTO pizzaDTO);
    public List<Tamanio> getTamanios();
}
