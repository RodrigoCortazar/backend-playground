package com.unam.apipizzasspringboot.service;

import com.unam.apipizzasspringboot.dto.PizzaDTO;
import com.unam.apipizzasspringboot.model.Pizza;
import com.unam.apipizzasspringboot.repository.IPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PizzaService implements IPIzzaService{

    @Autowired
    IPizzaRepository repository;

    @Override
    public List<PizzaDTO> getPizzasServ() {
        List<Pizza> pizzas = repository.getPizzasRepo();
        List<PizzaDTO> pizzasDTO = new ArrayList<>();
        if(pizzas.size()==0){
            return null;
        }
        pizzasDTO = pizzas
                .stream()
                .map(
                pizza -> new PizzaDTO(
                        pizza.getId(),
                        pizza.getNombre(),
                        pizza.getDescripcion(),
                        pizza.getTamanio().getNombre(),
                        pizza.getPrecio()
                    )
                )
                .toList();
        return pizzasDTO;
    }

    @Override
    public PizzaDTO getPizzaById(Long id) {
        Pizza pizza = repository.getPizzaById(id);
        PizzaDTO pizzaDTO;
        if(pizza==null){
            return null;
        }
        return new PizzaDTO(
                pizza.getId(),
                pizza.getNombre(),
                pizza.getDescripcion(),
                pizza.getTamanio().getNombre(),
                pizza.getPrecio()
        );
    }

    @Override
    public boolean deletePizzaById(Long id) {
        return repository.deletePizzaById(id);
    }
}
