package com.unam.apipizzasspringboot.repository;

import com.unam.apipizzasspringboot.model.Pizza;

import java.util.List;

public interface IPizzaRepository {
    public List<Pizza> getPizzasRepo();
    public Pizza getPizzaById(Long id);
    public boolean deletePizzaById(Long id);
}
