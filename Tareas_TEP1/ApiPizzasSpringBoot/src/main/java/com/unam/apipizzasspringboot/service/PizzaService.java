package com.unam.apipizzasspringboot.service;

import com.unam.apipizzasspringboot.dto.PizzaDTO;
import com.unam.apipizzasspringboot.model.Pizza;
import com.unam.apipizzasspringboot.model.Tamanio;
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

    private boolean parametrosCompletos(PizzaDTO pizzaDTO){
        if(pizzaDTO.getId()==null || pizzaDTO.getDescripcion()==null || pizzaDTO.getNombre()==null ||
                pizzaDTO.getTamanio()==null || pizzaDTO.getPrecio()==0.0){
                    System.out.println("Parametros incompletos");
            return false;
        }
        System.out.println("Parametros completos");
        return true;
    }

    @Override
    public boolean deletePizzaById(Long id) {
        return repository.deletePizzaById(id);
    }

    @Override
    public void createPizza(PizzaDTO pizzaDTO) {
        System.out.println("Metodo create");
        if(parametrosCompletos(pizzaDTO)){
            System.out.println("si entro");
            System.out.println("ID recibido: " + pizzaDTO.getId());
System.out.println("Pizza encontrada: " + repository.getPizzaById(pizzaDTO.getId()));
            if(repository.getPizzaById(pizzaDTO.getId())!=null){
                System.out.println(repository.getPizzaById(pizzaDTO.getId()));
                throw new UnsupportedOperationException("Ya existe pizza con ese id");
            }

            ArrayList<Tamanio>tamaniosCopy = repository.getCopyTamanios();
            Long indiceMayor=tamaniosCopy.stream().mapToLong(t->t.getId()).max().orElse(0L);
            Tamanio tam = tamaniosCopy
                    .stream()
                    .filter(t->t.getNombre().equalsIgnoreCase(pizzaDTO.getTamanio()))
                    .findFirst()
                    .orElse(null);
            if(tam==null){
                tam=repository.createTamanio(
                        new Tamanio(
                                indiceMayor,
                                pizzaDTO.getTamanio()
                        )
                );
            }

            repository.createPizza(
                    new Pizza(
                            pizzaDTO.getId(),
                            pizzaDTO.getNombre(),
                            pizzaDTO.getDescripcion(),
                            tam,//(tam!=null)?tam:new Tamanio(indiceMayor+1,pizzaDTO.getTamanio()),
                            pizzaDTO.getPrecio()
                    )
            );

        }else{
            throw new IllegalArgumentException("Campos faltantes o incorrectos");
        }
    }

    @Override
    public List<Tamanio> getTamanios() {
        return repository.getTamanios();
    }


    // TAMAÑOS


}
