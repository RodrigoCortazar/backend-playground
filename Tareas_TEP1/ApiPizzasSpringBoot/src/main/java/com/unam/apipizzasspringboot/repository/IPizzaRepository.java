package com.unam.apipizzasspringboot.repository;

import com.unam.apipizzasspringboot.model.Pizza;
import com.unam.apipizzasspringboot.model.Tamanio;

import java.util.ArrayList;
import java.util.List;

public interface IPizzaRepository {
    public List<Pizza> getPizzasRepo();
    public Pizza getPizzaById(Long id);
    public boolean deletePizzaById(Long id);
    public void createPizza(Pizza pizza);
    public ArrayList<Tamanio> getCopyTamanios();
    public Tamanio createTamanio(Tamanio tamanio);
    public List<Tamanio> getTamanios();
}
