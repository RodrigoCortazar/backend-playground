package com.unam.apipizzasspringboot.repository;

import com.unam.apipizzasspringboot.model.Pizza;
import com.unam.apipizzasspringboot.model.Tamanio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository {
    // Simulacion de Persistencia mediante ArrayList
    ArrayList<Tamanio> tamaniosArray = new ArrayList<>(
            List.of(
                    new Tamanio(1L,"Chica"),
                    new Tamanio(2L,"Mediana"),
                    new Tamanio(3L,"Grande")
            )
    );
    ArrayList<Pizza> pizzasArray = new ArrayList<Pizza>(
            List.of(
                    new Pizza(
                            1L,
                            "Peperoni",
                            "Queso con peperoni",
                            tamaniosArray
                                    .stream()
                                    .filter(
                                            ta->
                                                    ta.getNombre()=="Chica"
                                    ).findFirst().orElse(null),
                            100f
                    ),
                    new Pizza(
                            2L,
                            "Peperoni",
                            "Queso con peperoni",
                            tamaniosArray
                                    .stream()
                                    .filter(
                                            ta->
                                                    ta.getNombre()=="Mediana"
                                    ).findFirst().orElse(null),
                            150f
                    ),
                    new Pizza(
                            3L,
                            "Hawaiana",
                            "Queso con piña",
                            tamaniosArray
                                    .stream()
                                    .filter(
                                            ta->
                                                    ta.getNombre()=="Chica"
                                    ).findFirst().orElse(null),
                            100f
                    ),
                    new Pizza(
                            4L,
                            "Margarita",
                            "Tomate, mozzarella y ...",
                            tamaniosArray
                                    .stream()
                                    .filter(
                                            ta->
                                                    ta.getNombre()=="Grande"
                                    ).findFirst().orElse(null),
                            200f
                    ),
                    new Pizza(
                            5L,
                            "Margarita",
                            "Tomate, mozzarella y ...",
                            tamaniosArray
                                    .stream()
                                    .filter(
                                            ta->
                                                    ta.getNombre()=="Mediana"
                                    ).findFirst().orElse(null),
                            160f
                    )
            )
    );

    public ArrayList<Pizza> getPizzasRepo(){
        return pizzasArray;
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzasArray
                .stream()
                .filter(
                        pizza -> pizza.getId()==id
                ).findFirst().orElse(null);
    }

    @Override
    public boolean deletePizzaById(Long id) {
        return pizzasArray.removeIf(p->p.getId()==id);
    }
}
